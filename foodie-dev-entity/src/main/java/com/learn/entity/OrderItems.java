package com.learn.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单商品关联表 
 * </p>
 *
 * @author CamelliaV
 * @since 2024-08-04
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("order_items")
@ApiModel(value = "OrderItems对象", description = "订单商品关联表 ")
public class OrderItems implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId("id")
    private String id;

    @ApiModelProperty(value = "归属订单id")
    @TableField("order_id")
    private String orderId;

    @ApiModelProperty(value = "商品id")
    @TableField("item_id")
    private String itemId;

    @ApiModelProperty(value = "商品图片")
    @TableField("item_img")
    private String itemImg;

    @ApiModelProperty(value = "商品名称")
    @TableField("item_name")
    private String itemName;

    @ApiModelProperty(value = "规格id")
    @TableField("item_spec_id")
    private String itemSpecId;

    @ApiModelProperty(value = "规格名称")
    @TableField("item_spec_name")
    private String itemSpecName;

    @ApiModelProperty(value = "成交价格")
    @TableField("price")
    private Integer price;

    @ApiModelProperty(value = "购买数量")
    @TableField("buy_counts")
    private Integer buyCounts;
}
