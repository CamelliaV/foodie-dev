package com.learn.service.impl;

import com.learn.entity.Category;
import com.learn.mapper.CategoryMapper;
import com.learn.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品分类  服务实现类
 * </p>
 *
 * @author CamelliaV
 * @since 2024-08-04
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
