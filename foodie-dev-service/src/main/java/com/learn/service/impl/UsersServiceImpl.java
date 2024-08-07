package com.learn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.constants.UserConstant;
import com.learn.entity.Users;
import com.learn.enums.Sex;
import com.learn.mapper.UsersMapper;
import com.learn.req.UserReq;
import com.learn.service.UsersService;
import com.learn.utils.Encryptor;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private Sid sid;

    @Override
    public boolean queryUsernameIsExist(String username) {
        return usersMapper.exists(new QueryWrapper<Users>().eq("username", username));
    }

    @Transactional
    @Override
    public Users createUser(UserReq userReq) {
        Users user = Users
                .builder()
                .id(sid.nextShort())
                .username(userReq.getUsername())
                .password(Encryptor.encode(userReq.getPassword()))
                .face(UserConstant.DEFAULT_USER_FACE)
                .nickname(userReq.getUsername())
                .birthday(UserConstant.DEFAULT_USER_BIRTHDAY)
                .sex(Sex.SECRET.type)
                .createdTime(new Date())
                .updatedTime(new Date())
                .build();
        usersMapper.insert(user);
        return user;
    }

    @Override
    public Users queryUserForLogin(String username) {
        return usersMapper.selectOne(new QueryWrapper<Users>().eq("username", username));
    }
}
