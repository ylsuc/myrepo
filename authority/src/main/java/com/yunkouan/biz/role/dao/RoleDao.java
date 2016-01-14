package com.yunkouan.biz.role.dao;

import java.util.List;

import com.yunkouan.biz.role.entity.Role;

public interface RoleDao {
	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
	public void addRole(Role role);
	/**
	 * 更新角色
	 * @param role
	 * @return
	 */
	public Role modifyRole(Role role);
	/**
	 * 移除角色
	 * @param role
	 * @return
	 */
	public void removeRole(Role role);
	/**
	 * 查询角色
	 * @return
	 */
	public List<Role> findAllRole();
}
