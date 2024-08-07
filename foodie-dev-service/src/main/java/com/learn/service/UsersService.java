package com.learn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.entity.Users;
import com.learn.req.UserReq;

/**
 * <p>
 * 用户表  服务类
 * </p>
 *
 * @author CamelliaV
 * @since 2024-08-04
 */
public interface UsersService extends IService<Users> {

    boolean queryUsernameIsExist(String username);

    Users createUser(UserReq userReq);

    Users queryUserForLogin(String username);
}
