<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="/common/taglib.jsp" %>
<%@ include file="/common/common.jsp" %>    
<base href="<%=basePath%>">
<title>人员登录</title>
</head>
<body>
<div class="container">
<h2 class="bg-info">人员登录</h2>	
<form action="login/login.html" method="post">
	  <div class="form-group">
	    <label for="exampleInputEmail1">Username</label>
	    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Username" name="username">
	  </div>
	  <div class="form-group">
	    <label for="exampleInputPassword1">Password</label>
	    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password">
	  </div>
	  <button type="submit" class="btn btn-default">Submit</button>
	  <button type="reset" class="btn btn-default">Reset</button>
</form>
<br/>
<a href="" >返回主页</a>&nbsp;&nbsp;<a href="user/showUsers.html" >返回人员列表</a>&nbsp;&nbsp; <a href="user/addUserUI.html" >注册</a>
</div>
</body>
</html>
