package com.learn.mapper;

import com.learn.entity.ItemsSpec;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 商品规格 每一件商品都有不同的规格，不同的规格又有不同的价格和优惠力度，规格表为此设计 Mapper 接口
 * </p>
 *
 * @author CamelliaV
 * @since 2024-08-04
 */
public interface ItemsSpecMapper extends BaseMapper<ItemsSpec> {

}
