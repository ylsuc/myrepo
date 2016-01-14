package com.yunkouan.biz.operator.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.yunkouan.biz.operator.dao.OperatorDao;
import com.yunkouan.biz.operator.entity.Operator;

@Repository(value="operatorDao")
public class OperatorDaoImpl implements OperatorDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	public Operator addOperator(Operator operator){
		entityManager.persist(operator);
		return operator;
	}
	
	public Operator updateOperator(Operator operator){
		return entityManager.merge(operator);
	}
	
	public List<Operator> getOperators(){
		List<Operator> operators = null; 
		Query query = entityManager.createNamedQuery("Operator.findAll");
		operators = query.getResultList();
		return operators;
	}
	
	public void removeOperator(Operator operator){
		entityManager.remove(operator);
	}

	@Override
	public Operator findOperator(String loginName) {
		String jpql = "SELECT o FROM Operator o WHERE o.loginName =:loginName";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("loginName", loginName); 
		Operator operator = (Operator) query.getSingleResult();
		return operator;
	}
}
