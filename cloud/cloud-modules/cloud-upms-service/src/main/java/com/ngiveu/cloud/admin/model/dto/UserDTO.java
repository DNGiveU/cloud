package com.ngiveu.cloud.admin.model.dto;

import com.ngiveu.cloud.admin.model.entity.SysUser;

/**
 * @author gaz
 * @date 2017/11/5
 */
public class UserDTO extends SysUser {
	private static final long serialVersionUID = 2264913769943542143L;

	/**
     * 角色ID
     */
    private Integer role;

    private Integer deptId;

    /**
     * 新密码
     */
    private String newpassword1;

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getNewpassword1() {
		return newpassword1;
	}

	public void setNewpassword1(String newpassword1) {
		this.newpassword1 = newpassword1;
	}
}
