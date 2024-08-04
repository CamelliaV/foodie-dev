package com.learn.service.impl;

import com.learn.entity.ItemsSpec;
import com.learn.mapper.ItemsSpecMapper;
import com.learn.service.ItemsSpecService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品规格 每一件商品都有不同的规格，不同的规格又有不同的价格和优惠力度，规格表为此设计 服务实现类
 * </p>
 *
 * @author CamelliaV
 * @since 2024-08-04
 */
@Service
public class ItemsSpecServiceImpl extends ServiceImpl<ItemsSpecMapper, ItemsSpec> implements ItemsSpecService {

}
