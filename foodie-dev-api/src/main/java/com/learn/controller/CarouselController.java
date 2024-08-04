package com.learn.controller;

import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.learn.service.CarouselService;
import com.learn.entity.Carousel;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 轮播图  前端控制器
 * </p>
 *
 * @author CamelliaV
 * @since 2024-08-04
 */
@RestController
@RequestMapping("/carousel")
public class CarouselController {


    @Autowired
    private CarouselService carouselService;

    @GetMapping(value = "/")
    public ResponseEntity<Page<Carousel>> list(@RequestParam(required = false) Integer current, @RequestParam(required = false) Integer pageSize) {
        if (current == null) {
            current = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        Page<Carousel> aPage = carouselService.page(new Page<>(current, pageSize));
        return new ResponseEntity<>(aPage, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Carousel> getById(@PathVariable("id") String id) {
        return new ResponseEntity<>(carouselService.getById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Object> create(@RequestBody Carousel params) {
        carouselService.save(params);
        return new ResponseEntity<>("created successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        carouselService.removeById(id);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<Object> update(@RequestBody Carousel params) {
        carouselService.updateById(params);
        return new ResponseEntity<>("updated successfully", HttpStatus.OK);
    }
}
