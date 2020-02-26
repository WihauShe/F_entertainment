var content=document.getElementById("text");
var music=document.getElementById("music");
var joke=document.getElementById("joke");
var share=document.getElementById("share");
var one=document.getElementById("one");
var two=document.getElementById("two");
var three=document.getElementById("three");
var four=document.getElementById("four");
function showIndex(){
	content.style.display="block";
	music.style.display="none";
	joke.style.display="none";
	share.style.display="none";
	one.style.background="#E6E6E6";
	two.style.background="#000000";
	three.style.background="#000000";
	four.style.background="#000000";
}
function showMusic(){
	content.style.display="none";
	music.style.display="block";
	joke.style.display="none";
	share.style.display="none";
	one.style.background="#000000";
	two.style.background="#E6E6E6";
	three.style.background="#000000";
	four.style.background="#000000";
}
function showJoke(){
	content.style.display="none";
	music.style.display="none";
	joke.style.display="block";
	share.style.display="none";
	one.style.background="#000000";
	two.style.background="#000000";
	three.style.background="#E6E6E6";
	four.style.background="#000000";
}
function showShare(){
	content.style.display="none";
	music.style.display="none";
	joke.style.display="none";
	share.style.display="block";
	one.style.background="#000000";
	two.style.background="#000000";
	three.style.background="#000000";
	four.style.background="#E6E6E6";
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
	var pic=$("#uploadPic").val();
	var mus=$("#uploadMus").val();
	var joke=$("#up_joke").val();
	if(pic!=""||mus!=""||joke!=""){
		return true;
		
	}else{
		alert(pic);
		return false;
	}
	
}
function checkFlag(){
	var flag = $("#flag").val();
	if(flag==""){
		alert("Please Input Search Content");
		return false;
	}
	return true;
}
$(function () {            
    $(".micon").one("click",function () {
    	$(this).toggleClass('cs');
        var num = $(this).next().text() 
        num++; 
        $(this).next().text(num); 
        var musicId =$(this).parent().find('input').val();
        $.ajax({
        	url:"addMusicLike",
        	type:"post",
        	data:"musicId="+musicId,
        	datatype:"text",
        	success:function(data){}
        })
        
    });
    $(".jicon").one("click",function () {
        $(this).toggleClass('cs');
        var num = $(this).next().text() 
        num++; 
        $(this).next().text(num); 
        var jokeId =$(this).parent().find('input').val();
        $.ajax({
        	url:"addJokeLike",
        	type:"post",
        	data:"jokeId="+jokeId,
        	datatype:"text",
        	success:function(data){}
        })
    });
    $(".reportMusic").click(function () {
        var musicId = $(this).next().val();
        $.ajax({
        	url:"addMusicReport",
        	type:"post",
        	data:"musicId="+musicId,
        	datatype:"text",
        	success:function(data){
        		if(data=="true"){
    				alert("Report Success!");
    			}else{
    				alert("Report Failure!")
    			}
        	}
        })
    });
    $(".reportJoke").click(function () {
        var jokeId = $(this).next().val();
        $.ajax({
        	url:"addJokeReport",
        	type:"post",
        	data:"jokeId="+jokeId,
        	datatype:"text",
        	success:function(data){
        		if(data=="true"){
    				alert("Report Success!");
    			}else{
    				alert("Report Failure!")
    			}
        	}
        })
    });
    $(".show_comment").click(function(e){
    	$.post("getUsername",function(data){
    			if(data!=""){
    				$(e.target).closest('.joke_s').find(".comment ul").append("<li>"+data+":"+"<input type='text' name='context' placeholder='Your Comment'>"+
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
    
})
