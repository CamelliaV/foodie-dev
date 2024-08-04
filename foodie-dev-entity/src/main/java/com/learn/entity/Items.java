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
 * 商品表 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表
 * </p>
 *
 * @author CamelliaV
 * @since 2024-08-04
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("items")
@ApiModel(value = "Items对象", description = "商品表 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表")
public class Items implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品主键id")
    @TableId("id")
    private String id;

    @ApiModelProperty(value = "商品名称 商品名称")
    @TableField("item_name")
    private String itemName;

    @ApiModelProperty(value = "分类外键id 分类id")
    @TableField("cat_id")
    private Integer catId;

    @ApiModelProperty(value = "一级分类外键id")
    @TableField("root_cat_id")
    private Integer rootCatId;

    @ApiModelProperty(value = "累计销售 累计销售")
    @TableField("sell_counts")
    private Integer sellCounts;

    @ApiModelProperty(value = "上下架状态 上下架状态,1:上架 2:下架")
    @TableField("on_off_status")
    private Integer onOffStatus;

    @ApiModelProperty(value = "商品内容 商品内容")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    private Date createdTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("updated_time")
    private Date updatedTime;
}
