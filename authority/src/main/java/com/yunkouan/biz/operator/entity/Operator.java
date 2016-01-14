package com.yunkouan.biz.operator.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.yunkouan.biz.role.entity.Role;

@Entity
@Table(name="operator")
@NamedQuery(query=" SELECT o FROM Operator o ",name="Operator.findAll")
public class Operator {
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
	// 是否删除(1:已删除;0:未删除)
	private Integer deleted ;
	// 状态(1:启用;0:禁用)
	private Integer status;
	// 角色
	private List<Role> roles;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="nickname")
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickName) {
		this.nickname = nickName;
	}
	@Column(name="logingName")
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name="deleted")
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	@Column(name="status")
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Column(name="createTime")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(joinColumns={@JoinColumn(name="operator_id")},
			inverseJoinColumns={@JoinColumn(name="role_id")},
			name="operator_role")
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "Operator [id=" + id + ", nickname=" + nickname + ", loginName=" + loginName + ", password=" + password
				+ ", description=" + description + ", createTime=" + createTime + "]";
	}
}
