package com.yunkouan.biz.operator.service.impl;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yunkouan.biz.operator.dao.OperatorDao;
import com.yunkouan.biz.operator.entity.Operator;
import com.yunkouan.biz.operator.service.OperatorService;
import com.yunkouan.biz.operator.vo.OperatorVO;
import com.yunkouan.common.util.BeanMapper;

@Transactional
@Service(value="operatorService")
public class OperatorServiceImpl implements OperatorService {
	@Autowired
	private OperatorDao operatorDao;
	
	@Override
	public void addOperator(OperatorVO operatorVO) {
		Mapper mapper = new DozerBeanMapper();
		Operator operator = (Operator) mapper.map(operatorVO, Operator.class);
		
		operatorDao.addOperator(operator);
	}

	@Override
	public void modifyOperator(OperatorVO operatorVO) {

	}

	@Override
	public void removeOperator(OperatorVO operatorVO) {
		
	}

	@Override
	public List<OperatorVO> getOperatorVOs() {
		List<Operator> operators = operatorDao.getOperators();
		List<OperatorVO> operatorvos = BeanMapper.mapList(operators, OperatorVO.class);
		return operatorvos;
	}

	@Override
	public OperatorVO getOperator(String loginName) {
		Operator  operator = operatorDao.findOperator(loginName);
		OperatorVO operatorvo = BeanMapper.map(operator, OperatorVO.class);
		return operatorvo;
	}
}
