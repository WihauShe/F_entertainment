<%@page import="com.server.JokeServer"%>
<%@page import="com.server.MusicServer"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="com.server.CommentServer"%>
<%@ page import="com.entity.*"%>    
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta charset="utf-8" />
		<title>Entertainment</title>
		<link rel="icon" href="img/F.ico" type="image/x-icon"/>
		<link rel="stylesheet" type="text/css" href="css/index_admin.css" />
	</head>
	<%  
	  	ArrayList<Joke> jokes = (ArrayList<Joke>)ActionContext.getContext().get("jokes");
	  	ArrayList<Report> reports = (ArrayList<Report>)ActionContext.getContext().get("reports");
	  	CommentServer commentServer = new CommentServer();
	  	MusicServer musicServer = new MusicServer();
	  	JokeServer jokeServer = new JokeServer();
	 %>
	<body>
		<nav>
			<h1>F Entertainment</h1>
			<ul>
				<a href="javascript:void(0)" onclick="showIndex()"><li id="one">Index</li></a>
				<a href="javascript:void(0)" onclick="showMusic()"><li id="two">Music</li></a>
				<a href="javascript:void(0)" onclick="showJoke()"><li id="three">Joke</li></a>
				<a href="javascript:void(0)" onclick="showReport()"><li id="four">Reported</li></a>
			</ul>
			<div class="login_content">
				<s:if test="#session.user == null">
					<span><a href="login.html">Sign In</a></span>
					<span><a href="sign_up.html">Sign Up</a></span>
				</s:if>
				<s:else>
					<span>Welcome</span>
					<span><a href="person"><s:property value="#session.user.userName"/></a></span>
					<span><a href="logout">Logout</a></span>
				</s:else>
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
							<a href="javascript:;" onclick="return confirm('Delete it?')" class="delMusic">Delete</a>
							<input name="musicId" value="<s:property value="id"/>" type="hidden"/>
						</span>
					</div>
				</s:iterator>
				<div class="music_s">
					<span class="music_title">That girl.mp3</span>
					<audio src="musics/Believer.mp3" controls="controls"></audio>
					<span class="music_delete"><a href="#">Delete</a></span>
				</div>
			</div>
			<div class="index_joke" id="joke">
				<% for(int i=0;i<jokes.size();i++){ %>
					<div class="joke_s">
						<p>
							<%=jokes.get(i).getContent()%>
						</p>
						<span> 
							<i class="icon">&#10084;</i><b><%=jokes.get(i).getLike() %></b>
	    						<a href="javascript:;" class="show_comment">Comment</a>
	    						<a href="javascript:;" onclick="return confirm('Delete it?')" class="delJoke">Delete</a>
	    						<input name="jokeId" value="<%=jokes.get(i).getId() %>" type="hidden"/>
						</span>
						<div class="comment">
							<ul>
								<%ArrayList<Comment> comments = commentServer.getCommentsById(jokes.get(i).getId()); %>
								<%for(int j=0;j<comments.size();j++){ %>
									<li><%=comments.get(j).getUserName()%>:<%=comments.get(j).getContent()%></li>
									<li><hr/></li>
								<%} %>
							</ul>
						</div>
					
					</div>
				<%} %>
			</div>
			<div class="index_report" id="report">
				<%for(int i=0;i<reports.size();i++){%> 
					<div class="report_s">
						<%if(reports.get(i).getType().equals("joke")){ 
							Joke joke = new Joke();
							joke = jokeServer.getJokeById(reports.get(i).getContentId());
							if(joke!=null){
						%>
						<div class="joke_s">
							<p>
								<%=joke.getContent() %>
							</p>
							<span> 
			        				<i  class="icon">&#10084;</i><b><%=joke.getLike() %></b>
			    					<a href="javascript:;" onclick="return confirm('Delete it?')" class="delReport">Delete</a>
			    					<input name="reportId" value="<%=reports.get(i).getId() %>" type="hidden"/>
							</span>
						</div>
						<%}}else if(reports.get(i).getType().equals("music")){ 
							Music music = new Music();
							music = musicServer.getMusicById(reports.get(i).getContentId());
							if(music!=null){
						%>
						<div class="music_s">
							<span class="music_title"><%=music.getName() %></span>
							<audio src="<%=music.getPath() %>" controls="controls"></audio>
							<span class="music_delete">
								<a href="javascript:;" onclick="return confirm('Delete it?')" class="delReport">Delete</a>
								<input name="reportId" value="<%=reports.get(i).getId() %>" type="hidden"/>
							</span>
						</div>
						<%}} %>
					</div>
				<%} %>
			</div>
		</section>
	</body>
	<script src="js/jquery.min.js"></script>
	<script src="js/index_admin.js"></script>
	<script>
		
	</script>
</html>

