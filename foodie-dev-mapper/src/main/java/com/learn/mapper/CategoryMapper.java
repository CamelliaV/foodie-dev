package com.learn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learn.entity.Category;
import com.learn.resp.RecItemsResp;

import java.util.List;

/**
 * <p>
 * 商品分类  Mapper 接口
 * </p>
 *
 * @author CamelliaV
 * @since 2024-08-04
 */
public interface CategoryMapper extends BaseMapper<Category> {
    List<RecItemsResp> queryRecItems(Integer categoryId);
}
