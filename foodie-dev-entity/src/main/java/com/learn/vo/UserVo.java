package com.learn.vo;

import lombok.Data;

@Data
public class UserVo {
    private String username;
    private String password;
    private String confirmPassword;
}
