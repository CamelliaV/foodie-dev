package com.learn.controller;

import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.learn.service.UserAddressService;
import com.learn.entity.UserAddress;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 用户地址表  前端控制器
 * </p>
 *
 * @author CamelliaV
 * @since 2024-08-04
 */
@RestController
@RequestMapping("/user-address")
public class UserAddressController {


    @Autowired
    private UserAddressService userAddressService;

    @GetMapping(value = "/")
    public ResponseEntity<Page<UserAddress>> list(@RequestParam(required = false) Integer current, @RequestParam(required = false) Integer pageSize) {
        if (current == null) {
            current = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        Page<UserAddress> aPage = userAddressService.page(new Page<>(current, pageSize));
        return new ResponseEntity<>(aPage, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserAddress> getById(@PathVariable("id") String id) {
        return new ResponseEntity<>(userAddressService.getById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Object> create(@RequestBody UserAddress params) {
        userAddressService.save(params);
        return new ResponseEntity<>("created successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        userAddressService.removeById(id);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<Object> update(@RequestBody UserAddress params) {
        userAddressService.updateById(params);
        return new ResponseEntity<>("updated successfully", HttpStatus.OK);
    }
}
