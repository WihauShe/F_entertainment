function checkEmail(){
    var email = document.getElementById('email').value;
    if(!(/^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/.test(email))){   //手机号码验证的正则表达式
        emailError.style.display="block";
        emailZeng.style.height="50px";
    }else{
    	emailError.style.display="none";
    	emailZeng.style.height="30px";
    	var useremail = $('#email').val();
    	$.ajax({
    		url:"testUseremail",
    		data:"userEmail="+useremail,
    		success:function(data){
				alert(data);
				if(data=="true"){
					$("#emailError").html("Useremail is exist!");
					$("#emailZeng").css("height","50px");
					$("#emailError").show();
				}else{
					$("#emailError").html("Email is error, please input again!");
					$("#emailZeng").css("height","30px");
					$("#emailError").hide();
				}
    		}
    	});
    }
}
function checkName(){
	var username = document.getElementById('name').value;
	if(username.trim().length==0){  //用户名不可以为空，不可以有空格
		usernameError.style.display="block";
		nameZeng.style.height="50px";
	}
	else{
		usernameError.style.display="none";
		nameZeng.style.height="30px";
	}
}
function checkDate(){
	var date = document.getElementById('date').value;
	if(date==""){
		dateError.style.display="block";
		birthZeng.style.height="50px";
	}else{
		dateError.style.display="none";
		birthZeng.style.height="30px";
	}
}
function checkPass(){
	 var passwd = document.getElementById('passwd').value;
	 //密码必须是6到16位，且包括数字、字母或符号中的两种
    if(!(/(?!^[0-9]+$)(?!^[A-z]+$)(?!^[^A-z0-9]+$)^.{6,16}$/.test(passwd))){ 
        passError.style.display="block";
        passZeng.style.height="100px";
    } 
    else{
    	passError.style.display="none";
    	passZeng.style.height="30px";
    }
}

function check(){
	var email = document.getElementById('email').value;
	var username = document.getElementById('name').value;
	var date = document.getElementById('date').value;
	var passwd = document.getElementById('passwd').value;
	var repasswd = document.getElementById('repasswd').value;
    if(!(/^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/.test(email))){ 
        emailError.style.display="block";
        emailZeng.style.height="50px";
    }else if(username.trim().length==0){
		usernameError.style.display="block";
		nameZeng.style.height="50px";
	}else if(date==""){
		dateError.style.display="block";
		birthZeng.style.height="50px";
	}else if(!(/(?!^[0-9]+$)(?!^[A-z]+$)(?!^[^A-z0-9]+$)^.{6,16}$/.test(passwd))){ 
        passError.style.display="block";
        passZeng.style.height="100px"; 
    }else if(repasswd != passwd){
		repassError.style.display="block";  //密码确认在提交时验证
        repassZeng.style.height="50px";   
    }else{
    	repassError.style.display="none";
    	repassZeng.style.height="30px";
    	document.getElementById("input_submit").click();	
    }
}
$(function(){
	
})

