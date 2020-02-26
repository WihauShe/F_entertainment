<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<meta charset="UTF-8">
		<title>Sign_up</title>
		<link rel="icon" href="img/F.ico" type="image/x-icon"/>
		<link rel="stylesheet" type="text/css" href="css/sign_up.css"/>
		<script type="text/javascript" src="js/sign_up.js"></script>
	</head>
	<body>
	<div class="wrap">
		<div class="logo">
			<div class="logo_word">F Entertainment</div>
		</div>
		<div class="box">
			<form action="person.html" method="post">
				<div class="form-group">
					<div class="title">Welcome</div>
				</div>
				<div class="form-group" id="emailZeng">
					<label for="email">Email:</label>
					<input type="text" class="form-control" name="userEmail" id="email" onblur="checkEmail()">
					<div id="emailError" class="errorMsg">Email is error, please input again!</div>
				</div>
				<div class="form-group userName" id="nameZeng">
					<label for="user_name">Username:</label>
					<input type="text" class="form-control" name="userName" id="name" onblur="checkName()">
					<div id="usernameError" class="errorMsg">Username can not be none!</div>
				</div>
				<div class="form-group sex">
					<label>Sex:</label>
					<input type="radio" name="userSex" value="male" checked="checked">Male
					<input type="radio" name="userSex" value="female">Female
				</div>
				<div class="form-group userBirth" id="birthZeng" style="padding-right: 1px;">
					<label for="birth">Birthdate:</label>
					<input type="date" class="form-control" name="birthDate" id="date" placeholder="date">
					<div id="dateError" class="errorMsg col_1">Please input valid date!</div>
				</div>
				<div class="form-group password" id="passZeng">
					<label for="passwd">Password:</label>
					<input type="password" class="form-control" name="userPasswd" id="passwd" onblur="checkPass()">
					<div id="passError" class="errorMsg">Password must be between 6 and 16 bits and contain two types of
					letters, numbers, or symbols!</div>
				</div>
				<div class="form-group re" id="repassZeng">
					<label for="repasswd" class="pass_con">Password confirm:</label>
					<input type="password" class="form-control" name="repasswd" id="repasswd">
					<div id="repassError" class="errorMsg" style="padding-left:100px">Password is not same to up!</div>
				</div>
				<button type="button" class="btn" value="input_button" onclick="check()" id="sign">Sign up</button>
				<button type="submit" value="input_submit" id="input_submit" style="display:none;"></button>
			</form>
		</div>
		
	</div>
</body>
</html>

