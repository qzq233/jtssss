<%@page language="java" contentType="text/html;charset = UTF-8"
	pageEncoding="UTF-8"
	import = "team.pro.*"
	import = "team.database.*"
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%!
//database db = new database("jdbc:mysql://172.26.67.120:3306/usr","root","123");
//database db = new database("jdbc:mysql://172.28.144.56:3306/usr","root","123");
%>
<%!
	String assign = null;
%>
<%
	String proID4m = request.getParameter("proID4m");
	String proName4m = request.getParameter("proName4m");
	if(proID4m!= null && proName4m != null){
		session.setAttribute("proID4m", proID4m);
		session.setAttribute("proName4m", proName4m);
	}
	System.out.println(proID4m + " "+proName4m);
    assign = request.getParameter("assign");
	//System.out.println(assign);
	if(assign != null){
		String proName = request.getParameter("proName");
		String description = request.getParameter("description");
		String input = request.getParameter("input");
		String output = request.getParameter("output");
		String exampleInput = request.getParameter("exampleInput");
		String exampleOutput = request.getParameter("exampleOutput");
		String testcaseInput = request.getParameter("testcaseInput");
		String testcaseOutput = request.getParameter("testcaseOutput");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		//System.out.println("input "+input);
		
		if(proName != "" && description != "" &&  exampleInput != ""  && exampleOutput != "" && 
				input != "" &&  output != ""  && testcaseInput != "" && testcaseOutput != ""
				&& startTime != "" && endTime != ""){
		
			
			String rootPath = "/home/dazenhom/Desktop/WebTest/pro";
			//modify problem
			if((String)session.getAttribute("proID4m") != null && (String)session.getAttribute("proName4m") != null){
				String proID4mm = (String)session.getAttribute("proID4m");
				ProblemAbstract proA = new ProblemAbstract(Integer.parseInt(proID4mm),proName,10,startTime,endTime);
				Problem pro = new Problem(proA,db);
				pro.modifyProblem(proID4mm,rootPath, description, exampleInput, exampleOutput, 
						input, output, testcaseInput, testcaseOutput);

					session.setAttribute("proID4m", null);
					session.setAttribute("proName4m", null);			
			//create problem	
			}else{
				ProblemAbstract proA = new ProblemAbstract(0,proName,10,startTime,endTime);
				Problem pro = new Problem(proA,db);
				pro.assignProblem(rootPath, description, exampleInput, exampleOutput, 
					input, output, testcaseInput, testcaseOutput);
			}
			
			
			
			//session.setAttribute("assignState", "success");
			assign = "success";
		}else 
			//session.setAttribute("assignState", "fail");
			assign  = "fail";
	}
	else{
		System.out.println("empty in release");
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
						<script src="../js/lsetActive.js"></script>
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
			<form action = "releaseproblem.jsp?assign=ASSIGN" method = "post">
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<!--<h1 class="page-header">管理控制台</h1>-->
				<%
				//String assignState = (String)session.getAttribute("assignState");
				if(assign == null) {;}
				else if(assign.equals("success")){ %>
				<div class="alert alert-success">Assign Success</div>
				<%}else if(assign.equals("fail")){ %>
					<div class="alert alert-danger">Assign Error: Exists empty items</div>	
				<%	
				}
				%>
				<div class="col-md-10">
					<h2>Problem Name:</h2>
					<div>
						<input name = "proName" type = "text" style = "font-size: 25px; width: 300px; height: 40px" id = "release_pn"></input>
					<h2>Start Time</h2>
					<div>
						<input name = "startTime" type = "text" style = "font-size: 25px; width: 300px; height: 40px" id = "release_pn"></input>
					<h3>End Time</h3>
					<div>
						<input name = "endTime" type = "text" style = "font-size: 25px; width: 300px; height: 40px" id = "release_pn"></input>
					<h3>Description</h3>
					<div >
						<textarea  name = "description" rows="9" cols="65" class="textarea_style"></textarea>
					</div>
					<h3>Input</h3>
					<div >
						<textarea name = "input" rows="9" cols="65" class="textarea_style"></textarea>
					</div>
					<h3>Output</h3>
					<div >
						<textarea name = "output" rows="9" cols="65" class="textarea_style"></textarea>
					</div>
					<h3>Sample Input</h3>
					<div  >
						<textarea name = "exampleInput"  rows="9" cols="65" class="textarea_style"></textarea>
					</div>
					<h3>Sample Output</h3>
					<div  >
						<textarea name = "exampleOutput"  rows="9" cols="65" class="textarea_style"></textarea>
					</div>
					<h3>Testcase Input</h3>
					<div  >
						<textarea name = "testcaseInput"  rows="9" cols="65" class="textarea_style"></textarea>
					</div>
					<h3>Testcase Output</h3>
					<div  >
						<textarea name = "testcaseOutput"  rows="9" cols="65" class="textarea_style"></textarea>
					</div>
					<h3>Hint</h3>
					<div  >
						<textarea name = "hit"  rows="9" cols="65" class="textarea_style"></textarea>
					</div>
					<div>
						<button class="btn btn-primary btn-lg">submit</button>
					</div>
				</div>
			</div>
			</div>
			</form>
			</div>
			</div>
			
			<script type = "text/javascript">
				lsetActive("l_releaseProblem");
			</script>
			<script src="../js/jquery-1.11.1.min.js"></script>
			<script src="../js/bootstrap.min.js"></script>
			<!--<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>-->
</body>
</html>
