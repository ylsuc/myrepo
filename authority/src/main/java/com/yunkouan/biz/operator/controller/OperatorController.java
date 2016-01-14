package com.yunkouan.biz.operator.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.Preconditions;
import com.yunkouan.biz.operator.service.OperatorService;
import com.yunkouan.biz.operator.vo.OperatorVO;

@Controller
@RequestMapping(value="/operator")
public class OperatorController {
	@Autowired
	private OperatorService operatorService;
	
	/**
	 * 显示操作员画面
	 * @return
	 */
	@RequestMapping(value="/operatorView")
	public String operatorView(){
		System.out.println("view");
		System.out.println("view2");
		System.out.println("home change...");
		System.out.println("company change...");
		return "/system/operator/operator";
	}
	
	/**
	 * 登录
	 * @param operator
	 * @return
	 */
	@RequestMapping(value="/signIn")
	public String signIn(OperatorVO operator) {
		String loginName = operator.getLoginName();
		String password = operator.getPassword();
		
		OperatorVO operatornew = operatorService.getOperator(loginName);
		if(operatornew != null) {
			String pwd = operatornew.getPassword();
			if(password.equalsIgnoreCase(pwd)) {
				return "/system/operator/operator";
			}
		}
		
		return "redirect:index.jsp";
//		return "/system/operator/operator";
	}
	
	@RequestMapping(value="/listOperators")
	@ResponseBody
	public List<OperatorVO> listOperators(){
		List<OperatorVO> operators = new ArrayList<>();
		operators = operatorService.getOperatorVOs();
		return operators;
	}
	
	/**
	 * 添加操作员
	 * @return
	 */
	@RequestMapping(value="/addOperator")
	public String addOperator(OperatorVO operatorVO){
		operatorService.addOperator(operatorVO);
		return "success";
	}
	
	public String modifyOperator(OperatorVO operatorVO){
		operatorService.modifyOperator(operatorVO);
		return "success";
	}
}
