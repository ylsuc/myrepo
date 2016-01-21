<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/jsp/taglibs.jsp"%>
<%@ page import="java.util.*,com.yunkouan.biz.operator.vo.OperatorVO" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx}/resources/js/biz/operatorlist.js"></script>
<title>用户操作</title>
</head>
<body>
	<h2>用户操作</h2>
	
	<table id="operatorlist" class="table table-bordered">
		<tr>
			<td>登录名</td>
			<td>昵称</td>
			<td>描述</td>
			<td>创建时间</td>
			<td>已删除</td>
			<td>已启用</td>
			<td>操作</td>
		</tr>
		
		<c:forEach var="operator" items="${operators}">
			<tr>
				<td><c:out value="${operator.loginName}"/></td>
				<td><c:out value="${operator.nickname}"/></td>
				<td><c:out value="${operator.description}"/></td>
				<td><c:out value="${operator.createTime}"/></td>
				<td>
					<c:choose>
						<c:when test="${operator.deleted == 1}">
     						<input type="checkbox" checked="checked" class="chkDeleted"> 
						</c:when>
						<c:when test="${operator.deleted == 0}">
      						<input type="checkbox" class="chkDeleted"> 
						</c:when>
						<c:otherwise>
							Error
						</c:otherwise>
					</c:choose>
				</td>
				<td><c:out value=""/>
					<c:if test="${operator.status == 1}">
     						<input type="checkbox" checked="checked" class="chkStatus"> 
					</c:if>
					<c:if test="${operator.status == 0}">
     						<input type="checkbox" class="chkStatus"> 
					</c:if>
				</td>
				<td><input class="editOperator" type="button" value="编辑"></td>
				<input type="hidden" id="operator_id" name="operator_id" value="${operator.id}">
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>