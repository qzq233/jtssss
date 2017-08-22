
<%@ page language="java" pageEncoding="UTF-8" import="team.acc.*"
	import="team.database.*"%>
<%!//database db = new database("jdbc:mysql://172.26.67.120:3306/usr","root","123");
	static database db = new database("jdbc:mysql://172.28.51.26:3306/usr", "root", "123");%>


<!--下面是顶部导航栏的代码-->
<%!String username = null;
	String password = null;
	static Account tmp;%>
<%
	username = request.getParameter("username");
	password = request.getParameter("password");
	//System.out.println(username+" "+password);
	if (username != null && password != null) {
		tmp = db.searchUser(username);
		//System.out.println(tmp.getAccountName()+" "+tmp.getPassword());
		if (tmp != null && tmp.getPassword().equals(password)) {
			session.setAttribute("USERID", tmp.getID());
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			session.setAttribute("logState", "LOGIN");
		} else {
			;
		}
	}
	//System.out.println((String)session.getAttribute("username"));
	String logState = request.getParameter("logState");
	//System.out.println(logState + "in header.jsp");
	if (logState != null && logState.equals("LOGOUT")) {
		session.setAttribute("username", null);
		session.setAttribute("password", null);
		session.setAttribute("logState", null);
		//session.invalidate();
	}
%>

<nav class="navbar navbar-default navbar-inverse navbar-fixed-top"
	role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">SmartOJ</a>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav ">
				<li><a href= "SmartOJ.jsp">首页</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">功能<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li class="dropdown-header">功能</li>
						<li><a href="problemlist.jsp">题目列表</a></li>
						<li><a href="myproblem.jsp">我的任务</a></li>
						<li><a href="completed.jsp">完成题目</a></li>
						<li><a href="releaseproblem.jsp">发布题目</a></li>
						<li><a href="rank.jsp">排行榜</a></li>
						<li class="divider"></li>
						<li class="dropdown-header">系统功能</li>
						<li><a href="#">账户设置</a></li>
						<li><a href="#">帮助</a></li>
					</ul></li>
				<li><a href="#">帮助</a></li>
			</ul>
			<%
				String uname = (String) session.getAttribute("username");
				if (uname == null) {
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown" id="h_login"><a data-toggle="modal"
					href="#my_modal">登录</a></li>
			</ul>
			<%
				} else {
			%>
			<ul class="nav navbar-nav navbar-right " role="menu">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><%=uname%><span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">修改密码</a></li>
						<li><a href="SmartOJ.jsp?logState=LOGOUT">登出</a></li>
					</ul></li>
			</ul>
			<%
				}
			%>

		</div>
	</div>
</nav>


