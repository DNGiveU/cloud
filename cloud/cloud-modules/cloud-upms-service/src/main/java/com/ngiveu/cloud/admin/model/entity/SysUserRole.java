package com.ngiveu.cloud.admin.model.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 用户角色表
 * </p>
 *
 * @author gaz
 * @since 2017-10-29
 */
@TableName("sys_user_role")
public class SysUserRole extends Model<SysUserRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(type = IdType.INPUT)
	private Integer userId;
    /**
     * 角色ID
     */
	@TableId(type = IdType.INPUT)
	private Integer roleId;


	@Override
	protected Serializable pkVal() {
		return this.userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "SysUserRole{" +
			", userId=" + userId +
			", roleId=" + roleId +
			"}";
	}
}
