<%@page language="java" contentType="text/html;charset = UTF-8"
	pageEncoding="UTF-8" import="team.io.*" import = "team.sol.*" import = "team.jr.*"
	import = "java.text.Format"
	import = "java.text.SimpleDateFormat"
	import = "java.util.Date"
	
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
	String proID = request.getParameter("proID");
	String proName = request.getParameter("proName");
	
	if(proID != null && proName != null){
		session.setAttribute("proID", proID);
		session.setAttribute("proName", proName);
	}else{
		proID = (String)session.getAttribute("proID");
		proName = (String)session.getAttribute("proName");
	}

	String codeRootPath = "/home/dazenhom/Desktop/WebTest/pro"+proID;
	ProFileIO pfo = new ProFileIO(codeRootPath);
	
	//System.out.println(proID);
	String description = pfo.readDescription();
	String input = pfo.readInput();
	String output = pfo.readOutput();
	String exampleOutput = pfo.readExampleOutput();
	String exampleInput = pfo.readExampleIntput();
	//System.out.println(proID);
	
	String testcaseInputFilePath = pfo.getTestcaseInputPath();
	 //pfo.readReportFile("/home/dazenhom/Desktop/WebTest/pro1/output.txt");
	//String testcaseInputPath = pfo.getTestcaseInputPath();
	//String testcastOutputPath = pfo.getTestcaseOutputPath();
	if(request.getParameter("submit") != null){
		String code = request.getParameter("code");
		SolFileIO sfo = new SolFileIO(codeRootPath, testcaseInputFilePath,code);
		sfo.execute();
		String result = sfo.readReportFile();
		
		session.setAttribute("state", result);
		int UserID = (Integer)session.getAttribute("USERID"); 
		
		Format format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(format.format(new Date()));
		JudgeResult jr = new JudgeResult(0,UserID,Integer.parseInt(proID),result,0.0,0.0,100,format.format(new Date())); 
	
		db.solInsert(jr);
		
	}
	else{
		session.setAttribute("state", null);
	}
%>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>SmartOJ_problem</title>
		<link href="../css/bootstrap.min.css" rel="stylesheet">
			<link href="../css/signin.css" rel="stylesheet">
				<link href="../css/arrangement.css" rel="stylesheet">
					<link href="../css/problem.css" rel="stylesheet">
						<!--<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">-->
						<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->
</head>

<body>
	<!-- 顶部导航栏 -->
	<%@ include file="component/header.jsp"%>
	<!-- 模态登录弹出框 -->
	<%@ include file="component/loginfile.jsp"%>
	<!--自适应布局-->
	<div class="container-fluid">
		<div class="row">
			<%@ include file="component/leftnav.jsp"%>
			<!--右侧管理控制台-->
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<!--<h1 class="page-header">管理控制台</h1>-->
				<div class="col-md-10">
					<%
					String state = (String)session.getAttribute("state");
					//System.out.println("state:"+state);
					if(state == null ){
				 %>
					<div class="alert alert-warning">unsubmitted</div>
					<%}else if(  state.equals( "AC")){
				%>
				<div class="alert alert-success">Accept</div>
					<%}else if(  state.equals("CE")){
				%>
				<div class="alert alert-danger">Compile Error</div>
					<%}else if(  state.equals("TLE")){
				%>
				<div class="alert alert-danger">Time Limit Error</div>
					<%}else {
						System.out.print(state.equals(state));
				%>
				<div class="alert alert-danger">Wrong Answer</div>
				<%} %>
					<h2><%= proID + "    "+proName %></h2>
					<h3>description</h3>
					<div class="description">
						<p class="des_font">
							</>
							<%= description %>
						</p>
					</div>
					<h3>Input</h3>
					<div class="description">
						<p class="des_font">
							<%=input %>
						</p>
					</div>
					<h3>Output</h3>
					<div class="description">
						<p class="des_font">
							<%=output %>
						</p>
					</div>
					<h3>Sample Input</h3>
					<div class="description">
						<p class="des_font">
							<%= exampleInput %>
						</p>
					</div>
					<h3>Sample Output</h3>
					<div class="description">
						<p class="des_font">
							<%= exampleOutput %>
						</p>
					</div>
					<h3>Hint</h3>
					<div class="description">
						<p class="des_font"></p>
					</div>
					<div>
						<h3>Your Code</h3>
						<form action="problem.jsp?submit=1" method="post">
						<button class="btn btn-primary btn-lg">submit</button>
						<div>
							<div>
									<textarea name="code" rows="30" cols="130"
										class="textarea_style">
        						</textarea>
							</div>
						</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="../js/jquery-1.11.1.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<!--<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>-->
</body>
</html>
