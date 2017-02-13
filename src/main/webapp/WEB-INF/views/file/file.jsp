<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="/common/taglib.jsp" %>
<%@ include file="/common/common.jsp" %>    
<base href="<%=basePath%>">
<title>上传文件</title>
<script type="text/javascript">
	function check(){
		if($("#exampleInputFile").val() == ""){
			alert('请选择您要上传的文件，图片哟！');
			return false ;
		}else{
			return true ;
		}
	}

</script>
</head>
<body>
<div class="container">
<h2 class="bg-info">上传文件</h2>	
<table class="table table-bordered table-hover">
<thead>
<tr>
	<th>ID</th>
	<th>name</th>
	<th>文件</th>
</tr>
</thead>
<c:forEach items="${files }" var="file">
	<tr>
		<td>
			${file.id}	
		</td>
		<td>${file.name}</td>
		<td><a href="${file.url }"><img alt="" src="${file.url }" class="img-circle" height="100px;"></a></td>
	</tr>
</c:forEach>
</table>
<form action="file/upload.html" enctype="multipart/form-data" method="post" onsubmit="return check()">
  <div class="form-group">
    <label for="exampleInputFile">File input</label>
    <input type="file" id="exampleInputFile" name="file" />
    <p class="help-block">Example block-level help text here.</p>
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
  <br><br><a href="">返回主页</a>
</form>	
</div>
</body>
</html>
