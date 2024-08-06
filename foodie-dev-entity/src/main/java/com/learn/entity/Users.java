package com.learn.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表 
 * </p>
 *
 * @author CamelliaV
 * @since 2024-08-04
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("users")
@ApiModel(value = "Users对象", description = "用户表 ")
@Builder
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id 用户id")
    @TableId("id")
    private String id;

    @ApiModelProperty(value = "用户名 用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty(value = "密码 密码")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "昵称 昵称")
    @TableField("nickname")
    private String nickname;

    @ApiModelProperty(value = "真实姓名")
    @TableField("realname")
    private String realname;

    @ApiModelProperty(value = "头像")
    @TableField("face")
    private String face;

    @ApiModelProperty(value = "手机号 手机号")
    @TableField("mobile")
    private String mobile;

    @ApiModelProperty(value = "邮箱地址 邮箱地址")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "性别 性别 1:男  0:女  2:保密")
    @TableField("sex")
    private Integer sex;

    @ApiModelProperty(value = "生日 生日")
    @TableField("birthday")
    private Date birthday;

    @ApiModelProperty(value = "创建时间 创建时间")
    @TableField("created_time")
    private Date createdTime;

    @ApiModelProperty(value = "更新时间 更新时间")
    @TableField("updated_time")
    private Date updatedTime;
}
