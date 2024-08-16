package com.learn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.entity.Category;
import com.learn.enums.CategoryLevel;
import com.learn.mapper.CategoryMapper;
import com.learn.resp.RecItemsResp;
import com.learn.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> queryTopCategories() {
        return categoryMapper.selectList(new QueryWrapper<Category>().eq("type", CategoryLevel.TOP.value));
    }

    @Override
    public List<Category> querySubCategories(Integer rootId) {
        List<Category> all = categoryMapper.selectList(null);

        List<Category> categoryList = all.stream()
                                         .filter(category -> category.getFatherId()
                                                                     .equals(0))
                                         .peek(category -> category.setChildren(lsChildren(category, all)))
                                         .filter(category -> category.getId()
                                                                     .equals(rootId))
                                         .collect(Collectors.toList());


        return categoryList.isEmpty() ? categoryList : categoryList.get(0)
                                                                   .getChildren();
    }

    @Override
    public List<RecItemsResp> queryRecItems(Integer categoryId) {
        return categoryMapper.queryRecItems(categoryId);
    }

    private List<Category> lsChildren(Category root, List<Category> all) {
        return all.stream()
                  .filter(category -> category
                          .getFatherId()
                          .equals(root.getId()))
                  .peek(category -> category.setChildren(lsChildren(category, all)))
                  .collect(Collectors.toList());
    }
}
