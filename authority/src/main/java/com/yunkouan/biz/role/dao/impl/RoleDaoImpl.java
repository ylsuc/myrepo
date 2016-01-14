package com.yunkouan.biz.role.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.yunkouan.biz.role.dao.RoleDao;
import com.yunkouan.biz.role.entity.Role;

@Repository(value="roleDao")
public class RoleDaoImpl implements RoleDao{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void addRole(Role role) {
		entityManager.persist(role);
	}

	@Override
	public Role modifyRole(Role role) {
		return entityManager.merge(role);
	}

	@Override
	public void removeRole(Role role) {
		entityManager.remove(role);
	}

	@Override
	public List<Role> findAllRole() {
		return null;
	}

}
