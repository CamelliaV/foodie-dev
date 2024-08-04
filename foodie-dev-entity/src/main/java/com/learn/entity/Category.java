package com.learn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * 商品分类 
 * </p>
 *
 * @author CamelliaV
 * @since 2024-08-04
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("category")
@ApiModel(value = "Category对象", description = "商品分类 ")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "分类名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "分类类型")
    @TableField("type")
    private Integer type;

    @ApiModelProperty(value = "父id")
    @TableField("father_id")
    private Integer fatherId;

    @ApiModelProperty(value = "图标")
    @TableField("logo")
    private String logo;

    @ApiModelProperty(value = "口号")
    @TableField("slogan")
    private String slogan;

    @ApiModelProperty(value = "分类图")
    @TableField("cat_image")
    private String catImage;

    @ApiModelProperty(value = "背景颜色")
    @TableField("bg_color")
    private String bgColor;
}
