<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="/common/taglib.jsp" %>
<%@ include file="/common/common.jsp" %>    
<base href="<%=basePath%>">
<title>${user.username }登录成功</title>
</head>
<body>
<div class="container">
<h2 class="bg-info">登录成功</h2>	
${user.username },恭喜您登录成功！<br><br>
<a href="">返回主页</a>
</body>
</html>
