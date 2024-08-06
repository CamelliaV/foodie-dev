package com.learn.service;

import com.learn.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.mapper.UsersMapper;
import com.learn.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;

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

    Users createUser(UserVo userVo);
}
