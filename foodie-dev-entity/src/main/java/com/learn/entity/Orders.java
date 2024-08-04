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
 * 订单表;
 * </p>
 *
 * @author CamelliaV
 * @since 2024-08-04
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("orders")
@ApiModel(value = "Orders对象", description = "订单表;")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单主键;同时也是订单编号")
    @TableId("id")
    private String id;

    @ApiModelProperty(value = "用户id")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty(value = "收货人快照")
    @TableField("receiver_name")
    private String receiverName;

    @ApiModelProperty(value = "收货人手机号快照")
    @TableField("receiver_mobile")
    private String receiverMobile;

    @ApiModelProperty(value = "收货地址快照")
    @TableField("receiver_address")
    private String receiverAddress;

    @ApiModelProperty(value = "订单总价格")
    @TableField("total_amount")
    private Integer totalAmount;

    @ApiModelProperty(value = "实际支付总价格")
    @TableField("real_pay_amount")
    private Integer realPayAmount;

    @ApiModelProperty(value = "邮费;默认可以为零，代表包邮")
    @TableField("post_amount")
    private Integer postAmount;

    @ApiModelProperty(value = "支付方式")
    @TableField("pay_method")
    private Integer payMethod;

    @ApiModelProperty(value = "买家留言")
    @TableField("left_msg")
    private String leftMsg;

    @ApiModelProperty(value = "扩展字段")
    @TableField("extand")
    private String extand;

    @ApiModelProperty(value = "买家是否评价;1：已评价，0：未评价")
    @TableField("is_comment")
    private Integer isComment;

    @ApiModelProperty(value = "逻辑删除状态;1: 删除 0:未删除")
    @TableField("is_delete")
    private Integer isDelete;

    @ApiModelProperty(value = "创建时间（成交时间）")
    @TableField("created_time")
    private Date createdTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("updated_time")
    private Date updatedTime;
}
