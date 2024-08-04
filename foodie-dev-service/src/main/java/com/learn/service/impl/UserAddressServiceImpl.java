package com.learn.service.impl;

import com.learn.entity.UserAddress;
import com.learn.mapper.UserAddressMapper;
import com.learn.service.UserAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户地址表  服务实现类
 * </p>
 *
 * @author CamelliaV
 * @since 2024-08-04
 */
@Service
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements UserAddressService {

}
