package com.learn.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品规格 每一件商品都有不同的规格，不同的规格又有不同的价格和优惠力度，规格表为此设计
 * </p>
 *
 * @author CamelliaV
 * @since 2024-08-04
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("items_spec")
@ApiModel(value = "ItemsSpec对象", description = "商品规格 每一件商品都有不同的规格，不同的规格又有不同的价格和优惠力度，规格表为此设计")
public class ItemsSpec implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品规格id")
    @TableId("id")
    private String id;

    @ApiModelProperty(value = "商品外键id")
    @TableField("item_id")
    private String itemId;

    @ApiModelProperty(value = "规格名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "库存")
    @TableField("stock")
    private Integer stock;

    @ApiModelProperty(value = "折扣力度")
    @TableField("discounts")
    private BigDecimal discounts;

    @ApiModelProperty(value = "优惠价")
    @TableField("price_discount")
    private Integer priceDiscount;

    @ApiModelProperty(value = "原价")
    @TableField("price_normal")
    private Integer priceNormal;

    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    private Date createdTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("updated_time")
    private Date updatedTime;
}
