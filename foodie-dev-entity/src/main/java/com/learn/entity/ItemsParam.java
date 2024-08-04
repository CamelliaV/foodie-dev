package com.learn.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品参数 
 * </p>
 *
 * @author CamelliaV
 * @since 2024-08-04
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("items_param")
@ApiModel(value = "ItemsParam对象", description = "商品参数 ")
public class ItemsParam implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品参数id")
    @TableId("id")
    private String id;

    @ApiModelProperty(value = "商品外键id")
    @TableField("item_id")
    private String itemId;

    @ApiModelProperty(value = "产地 产地，例：中国江苏")
    @TableField("produc_place")
    private String producPlace;

    @ApiModelProperty(value = "保质期 保质期，例：180天")
    @TableField("foot_period")
    private String footPeriod;

    @ApiModelProperty(value = "品牌名 品牌名，例：三只大灰狼")
    @TableField("brand")
    private String brand;

    @ApiModelProperty(value = "生产厂名 生产厂名，例：大灰狼工厂")
    @TableField("factory_name")
    private String factoryName;

    @ApiModelProperty(value = "生产厂址 生产厂址，例：大灰狼生产基地")
    @TableField("factory_address")
    private String factoryAddress;

    @ApiModelProperty(value = "包装方式 包装方式，例：袋装")
    @TableField("packaging_method")
    private String packagingMethod;

    @ApiModelProperty(value = "规格重量 规格重量，例：35g")
    @TableField("weight")
    private String weight;

    @ApiModelProperty(value = "存储方法 存储方法，例：常温5~25°")
    @TableField("storage_method")
    private String storageMethod;

    @ApiModelProperty(value = "食用方式 食用方式，例：开袋即食")
    @TableField("eat_method")
    private String eatMethod;

    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    private Date createdTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("updated_time")
    private Date updatedTime;
}
