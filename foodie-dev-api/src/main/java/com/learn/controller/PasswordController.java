package com.learn.controller;

import com.learn.entity.Users;
import com.learn.req.UserReq;
import com.learn.resp.UserResp;
import com.learn.service.UsersService;
import com.learn.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/password")
public class PasswordController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/username-is-exist")
    public Result usernameIsExist(@RequestParam String username) {

        if (StringUtils.isBlank(username)) {
            return Result.errorMsg("Blank Username not allowed!");
        }

        boolean isExist = usersService.queryUsernameIsExist(username);
        if (isExist) {
            return Result.errorMsg("Username already exists!");
        }

        return Result.ok();
    }

    @PostMapping("/register")
    public Result register(@RequestBody UserReq userReq, HttpServletRequest request, HttpServletResponse response) {

        String username = userReq.getUsername();
        String password = userReq.getPassword();
        String confirmPassword = userReq.getConfirmPassword();

        if (StringUtils.isBlank(username)
            || StringUtils.isBlank(password)
            || StringUtils.isBlank(confirmPassword)) {
            return Result.errorMsg("Username or password cannot be blank!");
        }

        boolean isExist = usersService.queryUsernameIsExist(username);
        if (isExist) {
            return Result.errorMsg("Username already exists!");
        }

        String errorMsg = PasswordValidator.validate(password);
        if (!errorMsg.isEmpty()) {
            return Result.errorMsg(errorMsg);
        }

        if (!password.equals(confirmPassword)) {
            return Result.errorMsg("Inconsistent password!");
        }

        Users user = usersService.createUser(userReq);

        UserResp userResp = new UserResp();
        BeanUtils.copyProperties(user, userResp);
        CookieUtils.setCookie(request, response, "user", JsonUtils.objectToJson(userResp), true);

        return Result.ok(userResp);
    }

    @PostMapping("/login")
    public Result login(@RequestBody UserReq userReq, HttpServletRequest request, HttpServletResponse response) {
        String username = userReq.getUsername();
        if (StringUtils.isBlank(username)) {
            return Result.errorMsg("Username cannot be blank!");
        }
        Users user = usersService.queryUserForLogin(username);
        if (user == null) {
            return Result.errorMsg("User does not exist!");
        }
        if (!Encryptor.matches(userReq.getPassword(), user.getPassword())) {
            return Result.errorMsg("Incorrect password!");
        }
        UserResp userResp = new UserResp();
        BeanUtils.copyProperties(user, userResp);
        // should not be userdata, maybe some business-related id info
        CookieUtils.setCookie(request, response, "user", JsonUtils.objectToJson(userResp), true);

        return Result.ok(userResp);
    }

    @PostMapping("/logout")
    public Result logout(HttpServletRequest request, HttpServletResponse response) {

        CookieUtils.deleteCookie(request, response, "user");

        return Result.ok();
    }

}
