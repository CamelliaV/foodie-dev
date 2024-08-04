package com.learn.controller;

import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.learn.service.ItemsImgService;
import com.learn.entity.ItemsImg;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 商品图片  前端控制器
 * </p>
 *
 * @author CamelliaV
 * @since 2024-08-04
 */
@RestController
@RequestMapping("/items-img")
public class ItemsImgController {


    @Autowired
    private ItemsImgService itemsImgService;

    @GetMapping(value = "/")
    public ResponseEntity<Page<ItemsImg>> list(@RequestParam(required = false) Integer current, @RequestParam(required = false) Integer pageSize) {
        if (current == null) {
            current = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        Page<ItemsImg> aPage = itemsImgService.page(new Page<>(current, pageSize));
        return new ResponseEntity<>(aPage, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ItemsImg> getById(@PathVariable("id") String id) {
        return new ResponseEntity<>(itemsImgService.getById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Object> create(@RequestBody ItemsImg params) {
        itemsImgService.save(params);
        return new ResponseEntity<>("created successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        itemsImgService.removeById(id);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<Object> update(@RequestBody ItemsImg params) {
        itemsImgService.updateById(params);
        return new ResponseEntity<>("updated successfully", HttpStatus.OK);
    }
}
