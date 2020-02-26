<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta charset="UTF-8">
		<title></title>
		<link rel="icon" href="img/F.ico" type="image/x-icon"/>
		<link rel="stylesheet" type="text/css" href="css/person.css"/>
		<link rel="stylesheet" type="text/css" href="css/sign_up.css"/>
	</head>
	<body>
		<div class="wrap">
			<header>
				<h1>Personal HomePage <a href="enter" style="color:#fff;position:absolute;right:120px;top:10px;font-size:17px;text-decoration:none;">Back to Main></a>
					<div class="username" id="username"><s:property value="user.userName"/></div>
					<form action="#" method="post">
						<input class="signature" name="signature" value="<s:property value='signature'/>" id="signature" >
						<!-- input失去焦点时提交 --> 
					</form>
				</h1>
				<div class="credit" name="credit" id="credit">Credit:<s:property value="user.userCredit"/></div>
			</header>
			<!-- 第一个页面开始 -->
			<div class="page1" id="page1">
				<div class="main_head">
					<div class="personal">
						Personal Infomation
					</div>
					<button type="button" class="edit" onclick="goPage2()">Edit</button>
				</div>
				<div class="base_info">
					<div class="item">
						<div class="col_01">Email</div>
						<div class="col_02"><s:property value="user.userEmail"/></div>
						<a href="change_pass.html" class="change">Change password</a>
					</div>
					<div class="item">
						<div class="col_01">Username</div>
						<div class="col_02"><s:property value="user.userName"/></div>
					</div>
					<div class="item">
						<div class="col_01">Sex</div>
						<div class="col_02"><s:property value="user.userSex"/></div>
					</div>
					<div class="item">
						<div class="col_01">Birthdate</div>
						<div class="col_02"><s:property value="user.birthDate"/></div>
					</div>
					<div class="item">
						<div class="col_01"></div>
						<div class="col_02"></div>
					</div>
				</div>
			</div>
			<!-- 第一个页面结束 -->
			
			<!-- 第二个页面开始 -->
			<div class="page2" id="page2" style="display: none;">
				<form action="updateUser" method="post">
					<div class="form-group userName" id="nameZeng">
						<label for="userName">Username:</label>
						<input type="text" class="form-control" name="userName" id="name" onblur="checkName()">
						<div id="usernameError" class="errorMsg">Username can not be none!</div>
					</div>
					<div class="form-group sex">
						<label for="userSex">Sex:</label>
						<input type="radio" name="userSex" value="male" checked="checked">Male
						<input type="radio" name="userSex" value="female">Female
					</div>
					<div class="form-group userBirth" id="birthZeng" style="padding-right: 7.5px;">
						<label for="birthDate">Birthdate:</label>
						<input type="date" class="form-control" name="birthDate" id="date" placeholder="date" onblur="checkDate()">
						<div id="dateError" class="errorMsg col_1">Please input valid date!</div>
					</div>
					<button type="button" class="btn" value="input_button" onclick="checkEdit()">Submit</button>
					<button type="submit" value="input_submit" id="input_submit" style="display:none;"></button>
					<div class="mybtn">
						
						<button type="button" class="back_btn" onclick="backPage1()">Back</button>
						<button type="reset" value="reset" class="rebtn">Reset</button>
					</div>
					
				</form>
			</div>
			<!-- 第二个页面结束 -->
			
			
		</div>
	</body>
	<script src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/person.js"></script>
	<script type="text/javascript" src="js/sign_up.js"></script>
</html>

