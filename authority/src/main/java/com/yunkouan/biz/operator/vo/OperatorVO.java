package com.yunkouan.biz.operator.vo;

import java.util.Date;

public class OperatorVO {
	private Integer id;
	// 昵称
	private String nickname;
	// 登录名(帐号)
	private String loginName;
	// 密码
	private String password;
	// 描述
	private String description;
	// 创建时间
	private Date createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	@Override
	public String toString() {
		return "OperatorVO [id=" + id + ", nickname=" + nickname + ", loginName=" + loginName + ", password=" + password
				+ ", description=" + description + ", createTime=" + createTime + "]";
	}
}
