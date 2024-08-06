package com.learn.controller;

import com.learn.service.UsersService;
import com.learn.utils.PasswordValidator;
import com.learn.utils.Result;
import com.learn.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
            return Result.errorMap("Username already exists!");
        }

        return Result.ok();
    }

    @PostMapping("/register")
    public Result register(@RequestBody UserVo userVo) {

        String username = userVo.getUsername();
        String password = userVo.getPassword();
        String confirmPassword = userVo.getConfirmPassword();

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

        usersService.createUser(userVo);

        return Result.ok();
    }
}
