$(function(){
	$("#sendEmail").click(function(){
		if($("#sendEmail").attr("data-click")==0)
			return;
		var email = $('#userEmail').val();
		$.ajax({
			url:"sendCode",
			type:"post",
			data:"userEmail="+email,
			success:function(data){
				if(data=="true"){
					alert("Send Success");
					var time = 60;
					var interval = setInterval(function(){
						time--;
						$("#sendEmail").html("Already Send"+time);
						$("#sendEmail").attr("data-click",0);
						if(time==0){
							clearTimeout(interval);
							$("#sendEmail").attr("data-click",1);
						}
					},1000);
				}else{
					alert("Please Ensure Your Email");
				}
			}
		});
		$("#sendEmail").html("Resend");
	});
	$("#forget_pass").click(function(){
		var email = $('#userEmail').val();
		var code = $('#yz').val();
		var password = $('#passwd').val();
		$.ajax({
			url:"changePass",
			type:"post",
			data:"userEmail="+email+"&code="+code+"&userPassword="+password,
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