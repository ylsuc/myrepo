package com.yunkouan.biz.operator.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView operatorView(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/system/operator/operator");
		List<OperatorVO> operators = operatorService.getOperatorVOs();
		mav.addObject("operators", operators);
		return mav;
	}
	
	/**
	 * 登录
	 * @param operator
	 * @return
	 */
	@RequestMapping(value="/signIn")
	@ResponseBody
	public String signIn(OperatorVO operator) {
		String loginName = operator.getLoginName();
		String password = operator.getPassword();
		
		OperatorVO operatorTemp = operatorService.getOperator(loginName);
		if(operatorTemp != null) {
			String pwd = operatorTemp.getPassword();
			if(password.equalsIgnoreCase(pwd)) {
				return "/operator/operatorView";
			}
		}
		
		return "redirect:index.jsp";
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
