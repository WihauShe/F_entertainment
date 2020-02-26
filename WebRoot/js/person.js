
function goPage2(){
	page1.style.display="none";
	page2.style.display="block";
}

function backPage1(){
	page1.style.display="block";
	page2.style.display="none";
}

function checkEdit(){
	var username = document.getElementById('name').value;
	var date = document.getElementById('date').value;
    if(username.trim().length==0){
		usernameError.style.display="block";
		nameZeng.style.height="50px";
	}else if(date==""){
		dateError.style.display="block";
		birthZeng.style.height="50px";
	}else{
    	document.getElementById("input_submit").click();	
    }
}
$(function(){
	$("#signature").blur(function(){
		var signature = $(this).val();
		$.ajax({
			url:"updateSig",
			type:"post",
			data:"signature="+signature,
			success:function(data){
				if(data=="true"){
					alert("update success");
				}else{
					alert("update failure");
				}
			}
		})
	})
})
