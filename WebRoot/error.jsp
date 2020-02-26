<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<meta charset="UTF-8" />
	<title>Error</title>
	<link rel="icon" href="img/F.ico" type="image/x-icon"/>
	<link rel="stylesheet" type="text/css" href="css/error.css" />
</head>
<body>
		<section>
			<h1><a href="index.html">F Entertainment</a></h1>
			<div class="error_module">
				<span>Error Happened!，<a href="javascript:;" onClick="javascript:history.back(-1);">Return</a></span>
			</div>
			
		</section>
		
		<script src="js/TweenLite.min.js"></script>
		<script src="js/EasePack.min.js"></script>
		<script src="js/rAF.js"></script>
	  <script src="js/demo-1.js"></script>
	</body>
</html>

