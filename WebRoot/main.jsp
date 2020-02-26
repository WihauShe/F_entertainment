<%@page import="com.server.CommentServer"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.entity.*" %>
<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>F Entertainment</title>
    <link rel="icon" href="img/F.ico" type="image/x-icon"/>
	<link rel="stylesheet" type="text/css" href="css/index.css" />
  </head>
  <%  
  	ArrayList<Joke> jokes = (ArrayList<Joke>)ActionContext.getContext().get("jokes");
  	CommentServer commentServer = new CommentServer();
  %>
	<body>
		<nav>
			<h1>F Entertainment</h1>
			<ul>
				<a href="javascript:void(0)" onclick="showIndex()"><li id="one">Index</li></a>
				<a href="javascript:void(0)" onclick="showMusic()"><li id="two">Music</li></a>
				<a href="javascript:void(0)" onclick="showJoke()"><li id="three">Joke</li></a>
				<a href="javascript:void(0)" onclick="showShare()"><li id="four">Share</li></a>
			</ul>
			<div class="login_content">
				<s:if test="#session.user != null">
					<span>Welcome</span>
					<span><a href="person"><s:property value="#session.user.userName"/></a></span>
					<span><a href="logout">Logout</a></span>
				</s:if>
				<s:else>
					<span><a href="login.html">Sign In</a></span>
					<span><a href="sign_up.html">Sign Up</a></span>
				</s:else>
			</div>
			<div class="search">
				<form action="searchResult" method="post">
					<input type="text" name="flag" id="flag"/><button onclick="return checkFlag()"><img src="img/search.png"/></button>
				</form>
			</div>
			<div class="nav_bottom">
				<span>&copy;Copyright Reserved By XYZ</span>
			</div>
		</nav>
		<section>
			<div class="index_content" id="text">
				<span>Entertainments start from Here</span>
			</div>
			<div class="index_music" id="music">
				<s:iterator value="musics" id="musicList" var="music" status="status">
					<div class="music_s">
						<span class="music_title"><s:property value="name"/></span>
						<audio src="<s:property value="path"/>" controls="controls"></audio>
						<span> 
							<i class="micon">&#10084;</i><b><s:property value="like"/></b>
							<a href="javascript:;" onclick="return confirm('Report it?')" class="reportMusic">!</a>
							<input name="musicId" value="<s:property value="id"/>" type="hidden"/>
						</span>
					</div>
				</s:iterator>
			</div>
			<div class="index_joke" id="joke">
				<% for(int i=0;i<jokes.size();i++){ %>
					<div class="joke_s">
						<p>
							<%=jokes.get(i).getContent()%>
						</p>
						<span> 
							<i class="jicon">&#10084;</i><b><%=jokes.get(i).getLike() %></b>
	    					<a href="javascript:;" class="show_comment">Comment</a>
	    					<a href="javascript:;" class="btn_report reportJoke" onclick="return confirm('Report it?')">!</a>
	    					<input name="jokeId" value="<%=jokes.get(i).getId() %>" type="hidden"/>
						</span>
						<div class="comment">
							<ul>
								<%ArrayList<Comment> comments = commentServer.getCommentsById(jokes.get(i).getId()); %>
								<%for(int j=0;j<comments.size();j++){ %>
									<li><%=comments.get(j).getUserName()%>(<%=comments.get(j).getUserEmail()%>):<%=comments.get(j).getContent()%></li>
									<li><hr/></li>
								<%} %>
							</ul>
						</div>
					
					</div>
				<%} %>
				
			</div>
			<div class="index_share" id="share">
				<form class="share_content" action="upload" method="post" enctype="multipart/form-data">
					<div class="upMusic">
						<button class="btn" type="button"  onclick="openUploadMus()">Add Music</button>
						<input type="file" id="uploadMus" name="music" onchange="loadMus(this.files[0])" accept="audio/*"/>
						<span id="musName" style="vertical-align: middle; color: white;">None Music</span>
					</div>

					<textarea name="joke" id="up_joke"></textarea>s
					<input type="submit" class="btn" id="btn_upload" value="Submit" onclick="return checkUpload()" />
				</form>
			</div>
		</section>
	</body>
	<script src="js/jquery.min.js"></script>
	<script src="js/index.js"></script>
</html>

