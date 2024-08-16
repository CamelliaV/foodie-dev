package com.learn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.entity.Category;
import com.learn.resp.RecItemsResp;

import java.util.List;

/**
 * <p>
 * 商品分类  服务类
 * </p>
 *
 * @author CamelliaV
 * @since 2024-08-04
 */
public interface CategoryService extends IService<Category> {
    List<Category> queryTopCategories();

    List<Category> querySubCategories(Integer rootId);

    List<RecItemsResp> queryRecItems(Integer categoryId);
}
