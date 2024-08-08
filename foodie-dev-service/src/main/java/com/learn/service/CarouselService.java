package com.learn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.entity.Carousel;

import java.util.List;

/**
 * <p>
 * 轮播图  服务类
 * </p>
 *
 * @author CamelliaV
 * @since 2024-08-04
 */
public interface CarouselService extends IService<Carousel> {
    List<Carousel> queryCarouselsOnShow();
}
