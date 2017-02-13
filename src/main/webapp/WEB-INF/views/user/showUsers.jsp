<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="/common/taglib.jsp" %>
<%@ include file="/common/common.jsp" %>
<title>显示所有用户信息</title>
<base href="<%=basePath%>">
</head>
<body>
<div class="container">
	<h2 class="bg-info">展示用户</h2>
	<table class="table table-bordered table-hover">
	<thead>
	<tr>
		<th>Username</th>
		<th>Email</th>
		<th>Hobby</th>
		<th>ID</th>
		<th>Password</th>
		<th>操作</th>
	</tr>
	</thead>
	<c:forEach items="${users }" var="user">
		<tr>
			<td>
				${user.username }	
			</td>
			<td>${user.email }</td>
			<td>${user.hobby }</td>
			<td>${user.id }</td>
			<td>${user.password }</td>
			<td><a href="user/delUser/${user.id }.html">删除</a>|<a href="user/editUserUI/${user.id }.html">编辑</a></td>
		</tr>
	</c:forEach>
	</table>
	<br>
	<a href="">返回主页</a>&nbsp;&nbsp;<a href="user/addUserUI.html">添加用户</a> 
</div>
</body>
</html>
