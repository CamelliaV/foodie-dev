package com.learn.controller;

import com.learn.entity.Category;
import com.learn.resp.CategoryResp;
import com.learn.service.CarouselService;
import com.learn.service.CategoryService;
import com.learn.utils.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/index")
@RestController
public class IndexController {
    @Autowired
    private CarouselService carouselService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/sub-categories/{rootId}")
    public Result querySubCategories(@PathVariable Integer rootId) {

        List<Category> categories = categoryService.querySubCategories(rootId);
        List<CategoryResp> categoryRespList = categories.stream()
                                                        .map(this::convert)
                                                        .collect(Collectors.toList());

        return Result.ok(categoryRespList);
    }

    private CategoryResp convert(Category category) {
        List<CategoryResp> children = category.getChildren()
                                              .stream()
                                              .map(this::convert)
                                              .collect(Collectors.toList());
        CategoryResp categoryResp = convertCategoryToCategoryResp(category);
        categoryResp.setChildren(children);
        return categoryResp;
    }

    private CategoryResp convertCategoryToCategoryResp(Category category) {
        CategoryResp categoryResp = new CategoryResp();
        BeanUtils.copyProperties(category, categoryResp);
        return categoryResp;
    }

    @GetMapping("/carousel")
    public Result queryCarouselsOnShow() {
        return Result.ok(carouselService.queryCarouselsOnShow());
    }

    @GetMapping("/categories")
    public Result queryTopCategories() {
        return Result.ok(categoryService.queryTopCategories());
    }
}
