package com.learn.controller;

import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.learn.service.ItemsCommentsService;
import com.learn.entity.ItemsComments;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 商品评价表  前端控制器
 * </p>
 *
 * @author CamelliaV
 * @since 2024-08-04
 */
@RestController
@RequestMapping("/items-comments")
public class ItemsCommentsController {


    @Autowired
    private ItemsCommentsService itemsCommentsService;

    @GetMapping(value = "/")
    public ResponseEntity<Page<ItemsComments>> list(@RequestParam(required = false) Integer current, @RequestParam(required = false) Integer pageSize) {
        if (current == null) {
            current = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        Page<ItemsComments> aPage = itemsCommentsService.page(new Page<>(current, pageSize));
        return new ResponseEntity<>(aPage, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ItemsComments> getById(@PathVariable("id") String id) {
        return new ResponseEntity<>(itemsCommentsService.getById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Object> create(@RequestBody ItemsComments params) {
        itemsCommentsService.save(params);
        return new ResponseEntity<>("created successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        itemsCommentsService.removeById(id);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<Object> update(@RequestBody ItemsComments params) {
        itemsCommentsService.updateById(params);
        return new ResponseEntity<>("updated successfully", HttpStatus.OK);
    }
}
