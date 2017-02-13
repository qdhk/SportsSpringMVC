<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="/common/taglib.jsp" %>
<%@ include file="/common/common.jsp" %>    
<base href="<%=basePath%>">
<title>添加用户</title>
</head>
<body>
<div class="container">
<h2 class="bg-info">添加用户</h2>	
<c:if test="${flag == 1 }">
<h5 class="bg-danger">添加用户失败，Username重复</h5>
</c:if>
<span style="color: red;">
	${errors }
</span>
<form action="user/addUser.html" method="post">
	  <div class="form-group">
	    <label for="exampleInputEmail1">Username</label>
	    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Username" name="username" value="${user.username }">
	  </div>
	  <div class="form-group">
	    <label for="exampleInputEmail1">Email</label>
	    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email" name="email" value="${user.email }">
	  </div>
	  <div class="form-group">
	    <label for="exampleInputPassword1">Password</label>
	    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password" value="${user.password }">
	  </div>
	  <div class="form-group">
	    <label for="exampleInputEmail1">Yours Hobby</label>
	    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="hobby" name="hobby" value="${user.hobby }">
	  </div>	
	  <button type="submit" class="btn btn-default">Submit</button>
	  <button type="reset" class="btn btn-default">Reset</button>
</form>
<br/>
<a href="user/showUsers.html" >返回人员列表</a>
</div>
</body>
</html>
