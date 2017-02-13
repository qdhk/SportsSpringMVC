<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="<%=basePath%>bootstrap-3.3.5/css/bootstrap.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="<%=basePath%>jquery-1.11.3/jquery.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="<%=basePath%>bootstrap-3.3.5/js/bootstrap.js"></script>

