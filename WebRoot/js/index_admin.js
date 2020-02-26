var content=document.getElementById("text");
var music=document.getElementById("music");
var joke=document.getElementById("joke");
var	report=document.getElementById("report");
var one=document.getElementById("one");
var two=document.getElementById("two");
var three=document.getElementById("three");
var four=document.getElementById("four");
function showIndex(){
	content.style.display="block";
	music.style.display="none";
	joke.style.display="none";
	report.style.display="none";
	one.style.background="#E6E6E6";
	two.style.background="#000000";
	three.style.background="#000000";
	four.style.background="#000000";
}
function showMusic(){
	content.style.display="none";
	music.style.display="block";
	joke.style.display="none";
	report.style.display="none";
	one.style.background="#000000";
	two.style.background="#E6E6E6";
	three.style.background="#000000";
	four.style.background="#000000";
}
function showJoke(){
	content.style.display="none";
	music.style.display="none";
	joke.style.display="block";
	report.style.display="none";
	one.style.background="#000000";
	two.style.background="#000000";
	three.style.background="#E6E6E6";
	four.style.background="#000000";
}
function showReport(){
	content.style.display="none";
	music.style.display="none";
	joke.style.display="none";
	report.style.display="block";
	one.style.background="#000000";
	two.style.background="#000000";
	three.style.background="#000000";
	four.style.background="#E6E6E6";
}
function showComment(){
	$(".add_comment").show();
}

function openUploadPic() 
{ 
	$("#uploadPic").click(); 
} 
function openUploadMus() 
{ 
	$("#uploadMus").click(); 
} 


function loadPic(file){
    $("#picName").html(file.name);
}
function loadMus(file){
    $("#musName").html(file.name);
}
function checkUpload(){
	var pic=document.getElementById("uploadPic").value;
	var mus=document.getElementById("uploadMus").value;
	var joke=document.getElementById("up_joke").value;
	if(pic!=""||mus!=""||joke!=""){
		return true;
		
	}else{
		alert(pic);
		return false;
	}
}
$(function () {  
	$(".show_comment").click(function(e){
    	$.post("getUsername",function(data){
    			if(data!=""){
    				$(e.target).closest('.joke_s').find(".comment ul").append("<li>"+data+":"+"<input type='text' name='context'>"+
    					"<a href='javascript:;' class='add_comment' style='color:#ffffff;margin-right:10px;'>Submit</a>"+
    					"<a href='javascript:;' class='cancel' style='color:#ffffff;margin-right:10px;'>Cancel</a></li><li><hr/></li>");
    			}else{
    				alert("can't add comment!");
    			}
    		}
    	);
    });
    $(document).on("click",".cancel",function(e){
    	$(this).parent().next().remove();
    	$(this).parent().remove();
    });
    $(document).on("click",".add_comment",function(e){
    	var jokeid = $(this).closest('.comment').prev().find('input').val();
    	var context = $(e.target).prev().val();
		$.ajax({
			url:"addJokeComment",
			type:"post",
			data:"jokeId="+jokeid+"&context="+context,
			success:function(data){
				if(data=="true"){
					$(e.target).prev().replaceWith(context);
					$(e.target).next().remove();
					$(e.target).remove();
				}else{
					alert("try again!");
				}
			}	
		});
	});
   
    $(".delJoke").click(function(e){
    	var jokeId = $(this).next().val();
    	$.ajax({
    		url:"deleteJoke",
    		type:"post",
    		data:"jokeId="+jokeId,
    		dataType:"text",
    		success:function(data){
    			if(data=="true"){
    				$(e.target).closest('.joke_s').remove();
    				alert("Delete Success!");
    			}else{
    				alert("Delete Failure!")
    			}
    		}
    	})
    });
    $(".delMusic").click(function(e){
    	var musicId = $(this).next().val();
    	$.ajax({
    		url:"deleteMusic",
    		type:"post",
    		data:"musicId="+musicId,
    		dataType:"text",
    		success:function(data){
    			if(data=="true"){
    				$(e.target).closest('.music_s').remove();
    				alert("Delete Success!");
    			}else{
    				alert("Delete Failure!")
    			}
    		}
    	})
    });
    $(".delReport").click(function(e){
    	var reportId = $(this).next().val();
    	$.ajax({
    		url:"deleteReport",
    		type:"post",
    		data:"reportId="+reportId,
    		dataType:"text",
    		success:function(data){
    			if(data=="true"){
    				$(e.target).closest('.report_s').remove();
    				alert("Delete Success!");
    			}else{
    				alert("Delete Failure!")
    			}
    		}
    	})
    });
})