package com.yunkouan.biz.operator.dao;

import java.util.List;

import com.yunkouan.biz.operator.entity.Operator;

public interface OperatorDao {
	public Operator findOperator(String loginName);
	
	/**
	 * 添加操作员
	 * @param operator
	 * @return
	 */
	public Operator addOperator(Operator operator);
	/**
	 * 更新操作员
	 * @param operator
	 * @return
	 */
	public Operator updateOperator(Operator operator);
	/**
	 * 查询操作员
	 * @return
	 */
	public List<Operator> getOperators();
	/**
	 * 移除操作员
	 * @param operator
	 */
	public void removeOperator(Operator operator);
}
