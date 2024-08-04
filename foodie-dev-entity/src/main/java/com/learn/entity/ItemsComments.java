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
 * 商品评价表 
 * </p>
 *
 * @author CamelliaV
 * @since 2024-08-04
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("items_comments")
@ApiModel(value = "ItemsComments对象", description = "商品评价表 ")
public class ItemsComments implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id主键")
    @TableId("id")
    private String id;

    @ApiModelProperty(value = "用户id 用户名须脱敏")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty(value = "商品id")
    @TableField("item_id")
    private String itemId;

    @ApiModelProperty(value = "商品名称")
    @TableField("item_name")
    private String itemName;

    @ApiModelProperty(value = "商品规格id 可为空")
    @TableField("item_spec_id")
    private String itemSpecId;

    @ApiModelProperty(value = "规格名称 可为空")
    @TableField("sepc_name")
    private String sepcName;

    @ApiModelProperty(value = "评价等级 1：好评 2：中评 3：差评")
    @TableField("comment_level")
    private Integer commentLevel;

    @ApiModelProperty(value = "评价内容")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    private Date createdTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("updated_time")
    private Date updatedTime;
}
