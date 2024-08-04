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
 * 用户地址表 
 * </p>
 *
 * @author CamelliaV
 * @since 2024-08-04
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("user_address")
@ApiModel(value = "UserAddress对象", description = "用户地址表 ")
public class UserAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "地址主键id")
    @TableId("id")
    private String id;

    @ApiModelProperty(value = "关联用户id")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty(value = "收件人姓名")
    @TableField("receiver")
    private String receiver;

    @ApiModelProperty(value = "收件人手机号")
    @TableField("mobile")
    private String mobile;

    @ApiModelProperty(value = "省份")
    @TableField("province")
    private String province;

    @ApiModelProperty(value = "城市")
    @TableField("city")
    private String city;

    @ApiModelProperty(value = "区县")
    @TableField("district")
    private String district;

    @ApiModelProperty(value = "详细地址")
    @TableField("detail")
    private String detail;

    @ApiModelProperty(value = "扩展字段")
    @TableField("extand")
    private String extand;

    @ApiModelProperty(value = "是否默认地址")
    @TableField("is_default")
    private Integer isDefault;

    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    private Date createdTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("updated_time")
    private Date updatedTime;
}
