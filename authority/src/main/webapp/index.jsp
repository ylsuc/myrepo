<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/jsp/taglibs.jsp"%>
<html>
<head>
	<script type="text/javascript" src="${ctx}/resources/js/biz/index.js"></script>
</head>
<body>
	<div class="control-group">
		<label class="control-label" for="inputEmail">帐号</label>
		<div class="controls">
			<input type="text" id="loginName" name="loginName" value="" placeholder="帐号">
		</div>
	</div>
	
	<div class="control-group">
		<label class="control-label" for="inputPassword">密码</label>
		<div class="controls">
			<input type="password" id="password" name="password" value="" placeholder="密码">
		</div>
	</div>
	
	<div class="control-group">		
		<div class="controls">
			<button class="btn" id="btnSubmit">登录</button>
			<button class="btn" id="btnReset">取消</button>
		</div>
	</div>
</body>
</html>
