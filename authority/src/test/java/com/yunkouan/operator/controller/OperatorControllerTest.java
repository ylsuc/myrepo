package com.yunkouan.operator.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Test;
import org.springframework.http.MediaType;

import com.yunkouan.common.ApplicationContextBaseTest;

public class OperatorControllerTest extends ApplicationContextBaseTest{
	
//	@Test
	public void testSuccess() throws Exception{
		this.mockMvc.perform(get("/operator/testSuccess").accept(MediaType.parseMediaType("application/json;charset=UTF-8")).param("s", "hello java"))
		.andExpect(status().isOk());//.andExpect(content().contentType("application/text"));
//		.andExpect(jsonPath("$.name").value("Lee"));
	}
	
	@Test
	public void testAddOperator() throws Exception {
		this.mockMvc.perform(
				get("/operator/addOperator").
				accept(MediaType.parseMediaType("application/json;charset=UTF-8"))
				.param("nickname", "jack")
				.param("loginName", "admin")
				.param("password", "123456")
				.param("description", "管理员信息")
				.param("createTime", new Date().toString())
				)
		.andExpect(status().isOk());//.andExpect(content().contentType("application/json"))
//		.andExpect(jsonPath("$.name").value("Lee"));
	}
}
