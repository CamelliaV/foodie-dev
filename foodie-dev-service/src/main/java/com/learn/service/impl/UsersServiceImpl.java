package com.learn.service.impl;

import com.learn.entity.Users;
import com.learn.mapper.UsersMapper;
import com.learn.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表  服务实现类
 * </p>
 *
 * @author CamelliaV
 * @since 2024-08-04
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

}
