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
 * 商品图片 
 * </p>
 *
 * @author CamelliaV
 * @since 2024-08-04
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("items_img")
@ApiModel(value = "ItemsImg对象", description = "商品图片 ")
public class ItemsImg implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "图片主键")
    @TableId("id")
    private String id;

    @ApiModelProperty(value = "商品外键id 商品外键id")
    @TableField("item_id")
    private String itemId;

    @ApiModelProperty(value = "图片地址 图片地址")
    @TableField("url")
    private String url;

    @ApiModelProperty(value = "顺序 图片顺序，从小到大")
    @TableField("sort")
    private Integer sort;

    @ApiModelProperty(value = "是否主图 是否主图，1：是，0：否")
    @TableField("is_main")
    private Integer isMain;

    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    private Date createdTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("updated_time")
    private Date updatedTime;
}
