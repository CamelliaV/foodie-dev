package com.learn.service.impl;

import com.learn.entity.Items;
import com.learn.mapper.ItemsMapper;
import com.learn.service.ItemsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品表 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表 服务实现类
 * </p>
 *
 * @author CamelliaV
 * @since 2024-08-04
 */
@Service
public class ItemsServiceImpl extends ServiceImpl<ItemsMapper, Items> implements ItemsService {

}
