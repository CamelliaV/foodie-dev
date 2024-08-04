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
 * 轮播图 
 * </p>
 *
 * @author CamelliaV
 * @since 2024-08-04
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("carousel")
@ApiModel(value = "Carousel对象", description = "轮播图 ")
public class Carousel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId("id")
    private String id;

    @ApiModelProperty(value = "图片 图片地址")
    @TableField("image_url")
    private String imageUrl;

    @ApiModelProperty(value = "背景色")
    @TableField("background_color")
    private String backgroundColor;

    @ApiModelProperty(value = "商品id 商品id")
    @TableField("item_id")
    private String itemId;

    @ApiModelProperty(value = "商品分类id 商品分类id")
    @TableField("cat_id")
    private String catId;

    @ApiModelProperty(value = "轮播图类型 轮播图类型，用于判断，可以根据商品id或者分类进行页面跳转，1：商品 2：分类")
    @TableField("type")
    private Integer type;

    @ApiModelProperty(value = "轮播图展示顺序")
    @TableField("sort")
    private Integer sort;

    @ApiModelProperty(value = "是否展示")
    @TableField("is_show")
    private Integer isShow;

    @ApiModelProperty(value = "创建时间 创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "更新时间 更新")
    @TableField("update_time")
    private Date updateTime;
}
