package com.learn.controller;

import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.learn.service.ItemsParamService;
import com.learn.entity.ItemsParam;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 商品参数  前端控制器
 * </p>
 *
 * @author CamelliaV
 * @since 2024-08-04
 */
@RestController
@RequestMapping("/items-param")
public class ItemsParamController {


    @Autowired
    private ItemsParamService itemsParamService;

    @GetMapping(value = "/")
    public ResponseEntity<Page<ItemsParam>> list(@RequestParam(required = false) Integer current, @RequestParam(required = false) Integer pageSize) {
        if (current == null) {
            current = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        Page<ItemsParam> aPage = itemsParamService.page(new Page<>(current, pageSize));
        return new ResponseEntity<>(aPage, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ItemsParam> getById(@PathVariable("id") String id) {
        return new ResponseEntity<>(itemsParamService.getById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Object> create(@RequestBody ItemsParam params) {
        itemsParamService.save(params);
        return new ResponseEntity<>("created successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        itemsParamService.removeById(id);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<Object> update(@RequestBody ItemsParam params) {
        itemsParamService.updateById(params);
        return new ResponseEntity<>("updated successfully", HttpStatus.OK);
    }
}
