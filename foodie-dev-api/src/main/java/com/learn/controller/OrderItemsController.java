package com.learn.controller;

import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.learn.service.OrderItemsService;
import com.learn.entity.OrderItems;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 订单商品关联表  前端控制器
 * </p>
 *
 * @author CamelliaV
 * @since 2024-08-04
 */
@RestController
@RequestMapping("/order-items")
public class OrderItemsController {


    @Autowired
    private OrderItemsService orderItemsService;

    @GetMapping(value = "/")
    public ResponseEntity<Page<OrderItems>> list(@RequestParam(required = false) Integer current, @RequestParam(required = false) Integer pageSize) {
        if (current == null) {
            current = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        Page<OrderItems> aPage = orderItemsService.page(new Page<>(current, pageSize));
        return new ResponseEntity<>(aPage, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderItems> getById(@PathVariable("id") String id) {
        return new ResponseEntity<>(orderItemsService.getById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Object> create(@RequestBody OrderItems params) {
        orderItemsService.save(params);
        return new ResponseEntity<>("created successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        orderItemsService.removeById(id);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<Object> update(@RequestBody OrderItems params) {
        orderItemsService.updateById(params);
        return new ResponseEntity<>("updated successfully", HttpStatus.OK);
    }
}
