package com.learn.req;

import lombok.Data;

@Data
public class UserReq {
    private String username;
    private String password;
    private String confirmPassword;
}
