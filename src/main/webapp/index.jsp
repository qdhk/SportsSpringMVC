<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/common/common.jsp" %>
<%@ include file="/common/taglib.jsp" %>    
<base href="<%=basePath %>">
<script type="text/javascript">
$(document).ready(function(){
	$("#logout").click(function(){
		logout();
	});
	function logout(){
		   $.ajax({
		            type:"POST",
		            url:"login/logout.html",
		            data:{},
		            datatype: "text",//"xml", "html", "script", "json", "jsonp", "text".
		            beforeSend:function(){},
		            //成功返回之后调用的函数             
		            success:function(data){
		            	window.location.reload();          
		            },
		            //调用执行(success方法)后调用的函数
		            complete: function(XMLHttpRequest, textStatus){
		            },
		            //调用出错执行的函数
		            error: function(){
		                //请求出错处理
		            }         
		         });
		  }
});

</script>
</head>
<body>
	<div class="container"> 
	<h1>SpringMvc的学习</h1>
	<h4>我们通过以下几个场景来一起学习<c:if test="${not empty  userName}">,当前学习者：${userName } </c:if></h4>
	1、<a href="user/showUsers.html">人员管理</a><br>
	2、<a href="login/loginUI.html">人员登录</a><br>
	3、<a href="file/fileUI.html">上传文件</a><br>
	4、<a href="login/otherHandUI.html">其他资源</a><br>
	5、<a href="javascript:void()" id="logout">注销</a>
	</div>
</body>
</html>
