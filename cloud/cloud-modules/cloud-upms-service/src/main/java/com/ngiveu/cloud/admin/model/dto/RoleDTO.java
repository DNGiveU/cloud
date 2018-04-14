package com.ngiveu.cloud.admin.model.dto;

import com.ngiveu.cloud.admin.model.entity.SysRole;

/**
 * @author gaz
 * @date 2018/1/20
 * 角色Dto
 */
public class RoleDTO extends SysRole {
    /**
     * 角色部门Id
     */
    private Integer roleDeptId;

    /**
     * 部门名称
     */
    private String deptName;

	public Integer getRoleDeptId() {
		return roleDeptId;
	}

	public void setRoleDeptId(Integer roleDeptId) {
		this.roleDeptId = roleDeptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}
