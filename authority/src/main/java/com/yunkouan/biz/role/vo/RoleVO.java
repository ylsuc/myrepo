package com.yunkouan.biz.role.vo;

import java.util.Date;
import java.util.List;

import com.yunkouan.biz.operator.vo.OperatorVO;

public class RoleVO {
	private Integer id;
	private String roleName;
	private String description;
	private Date createTime;
	private List<OperatorVO> operators;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public List<OperatorVO> getOperators() {
		return operators;
	}
	public void setOperators(List<OperatorVO> operators) {
		this.operators = operators;
	}
	
	
}
