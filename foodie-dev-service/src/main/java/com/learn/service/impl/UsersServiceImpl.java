package com.learn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.constants.UserConstant;
import com.learn.entity.Users;
import com.learn.enums.Sex;
import com.learn.mapper.UsersMapper;
import com.learn.service.UsersService;
import com.learn.utils.Encryptor;
import com.learn.vo.UserVo;
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
    public Users createUser(UserVo userVo) {
        Users user = Users.builder()
                .id(sid.nextShort())
                .username(userVo.getUsername())
                .password(Encryptor.encode(userVo.getPassword()))
                .face(UserConstant.DEFAULT_USER_FACE)
                .nickname(userVo.getUsername())
                .birthday(UserConstant.DEFAULT_USER_BIRTHDAY)
                .sex(Sex.SECRET.type)
                .createdTime(new Date())
                .updatedTime(new Date())
                .build();
        usersMapper.insert(user);
        return user;
    }
}
