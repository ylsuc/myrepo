<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/jsp/taglibs.jsp"%>
<html>
<head>
	<script type="text/javascript" src="${ctx}/resources/js/biz/index.js"></script>
</head>
<body>
	<div>
		<input type="text" id="loginName" name="loginName" value=""/><br>
		<input type="password" id="password" name="password" value=""/><br>
		<input type="button" id="btnSubmit" value="登录"/>
		<input type="button" id="btnReset" value="取消"/>
	</div>
</body>
</html>
