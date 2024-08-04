package com.learn.controller;

import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.learn.service.ItemsSpecService;
import com.learn.entity.ItemsSpec;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 商品规格 每一件商品都有不同的规格，不同的规格又有不同的价格和优惠力度，规格表为此设计 前端控制器
 * </p>
 *
 * @author CamelliaV
 * @since 2024-08-04
 */
@RestController
@RequestMapping("/items-spec")
public class ItemsSpecController {


    @Autowired
    private ItemsSpecService itemsSpecService;

    @GetMapping(value = "/")
    public ResponseEntity<Page<ItemsSpec>> list(@RequestParam(required = false) Integer current, @RequestParam(required = false) Integer pageSize) {
        if (current == null) {
            current = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        Page<ItemsSpec> aPage = itemsSpecService.page(new Page<>(current, pageSize));
        return new ResponseEntity<>(aPage, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ItemsSpec> getById(@PathVariable("id") String id) {
        return new ResponseEntity<>(itemsSpecService.getById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Object> create(@RequestBody ItemsSpec params) {
        itemsSpecService.save(params);
        return new ResponseEntity<>("created successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        itemsSpecService.removeById(id);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<Object> update(@RequestBody ItemsSpec params) {
        itemsSpecService.updateById(params);
        return new ResponseEntity<>("updated successfully", HttpStatus.OK);
    }
}
