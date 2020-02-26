function checkUserEmail(){
    var email = document.getElementById('userEmail').value;
    if(!(/^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/.test(email))){   //手机号码验证的正则表达式
        emailError.style.display="block";
        emailZeng.style.height="50px";
    } 
    else{
    	emailError.style.display="none";
    	emailZeng.style.height="30px";
    }
}function checkYanz(){
	var yz = document.getElementById('yz').value;
	if(yz.trim().length==0){
    	yanzError.style.display="block";
    	yanzZeng.style.height="50px";
   }else{
   		yanzError.style.display="none";
    	yanzZeng.style.height="30px";
   }
}
function checkNewPass(){
	 var passwd = document.getElementById('passwd').value;
	 //密码必须是6到16位，且包括数字、字母或符号中的两种
    if(!(/(?!^[0-9]+$)(?!^[A-z]+$)(?!^[^A-z0-9]+$)^.{6,16}$/.test(passwd))){ 
        passError.style.display="block";
        passZeng.style.height="80px";
    } 
    else{
    	passError.style.display="none";
    	passZeng.style.height="30px";
    }
}
function checkChange(){
	var passwd = document.getElementById('passwd').value;
	var repasswd = document.getElementById('repasswd').value;
	var yz = document.getElementById('yz').value;
    //验证码的判断未写好
    if(yz == ""){
    	yanzError.style.display="block";
    	yanzZeng.style.height="50px";
    }
    else if(!(/(?!^[0-9]+$)(?!^[A-z]+$)(?!^[^A-z0-9]+$)^.{6,16}$/.test(passwd))){ 
        passError.style.display="block";
        passZeng.style.height="80px"; 
    } 
	else if(repasswd != passwd){
		repassError.style.display="block";  //密码确认在提交时验证
        repassZeng.style.height="50px";   
    } 
    else{
    	repassError.style.display="none";
    	repassZeng.style.height="30px";
    	document.getElementById("input_submit").click();	
    }
}
function checkForm(){
	var email = document.getElementById('userEmail').value;
	var passwd = document.getElementById('passwd').value;
	var repasswd = document.getElementById('repasswd').value;
	var yz = document.getElementById('yz').value;
   
	if(!(/^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/.test(email))){ 
        emailError.style.display="block";
        emailZeng.style.height="50px";
    }else if(yz == ""){
    	yanzError.style.display="block";
    	yanzZeng.style.height="50px";
    }else if(!(/(?!^[0-9]+$)(?!^[A-z]+$)(?!^[^A-z0-9]+$)^.{6,16}$/.test(passwd))){ 
        passError.style.display="block";
        passZeng.style.height="80px"; 
    }else if(repasswd != passwd){
		repassError.style.display="block";  //密码确认在提交时验证
        repassZeng.style.height="50px";   
    }else{
    	repassError.style.display="none";
    	repassZeng.style.height="30px";
    	return true;
    }
	return false;
}
$(function(){
	$("#sendCode").click(function(){
		if($("#sendCode").attr("data-click")==0)
			return;
		$.post("sendCode","userEmail=noemail",function(data){
				if(data=="true"){
					alert("Send Success");
					var time = 60;
					var interval = setInterval(function(){
						time--;
						$("#sendCode").html("Already Send"+time);
						$("#sendCode").attr("data-click",0);
						if(time==0){
							clearTimeout(interval);
							$("#sendCode").attr("data-click",1);
						}
					},1000);
				}else{
					alert("Please Ensure Your Email");
				}
			}
		);
		$("#sendCode").html("Resend");
	});
	$("#input_submit").click(function(){
		var code = $('#yz').val();
		var password = $('#passwd').val();
		$.ajax({
			url:"changePass",
			type:"post",
			data:"userEmail=noemail&code="+code+"&userPassword="+password,
			success:function(data){
				if(data=="true"){
					alert("Change Success");
					window.location.href="logout";
				}else{
					alert("Change Failure");
				}
			}
		});
	});

	
})