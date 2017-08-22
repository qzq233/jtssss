<%@page language="java" contentType="text/html;charset = UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>SmartOJ</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/signin.css" rel="stylesheet">
<link href="../css/arrangement.css" rel="stylesheet">
<!--<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">-->
<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->
<script src="../js/lsetActive.js"></script>
</head>
<%
	String O_logState = (String)session.getAttribute("logState");
	System.out.println(O_logState);
	if(O_logState != null && O_logState.equals("LOGIN")){
		response.sendRedirect("SmartOJ_loged.jsp");
	}
	
%>
<body>
	<!-- 顶部导航栏 -->
	<%@include file="component/header.jsp"%>
	<!-- 模态登录弹出框 -->
	<%@ include file="component/loginfile.jsp"%>
	<!-- 自适应布局 -->
	<div class="container-fluid">
		<div class="row">
			<!-- 左侧导航栏-->
			<%@ include file="component/leftnav.jsp"%>
			<!--右侧管理控制台-->
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<!--<h1 class="page-header">管理控制台</h1>-->
				<div class="row">
					<div class="col-md-8">
						<%@ include file="component/panel_newpro.jsp"%>
					</div>
					<div class="col-md-4 ">
						<%@ include file="component/panel_remind.jsp"%>
					</div>
				</div>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<!--<h1 class="page-header">管理控制台</h1>-->
				<div class="row">
					<div class="col-md-12">
						<%@ include file="component/panel_rank.jsp"%>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<script type="text/javascript">
		lsetActive("l_mainPage");
	</script>

	<script src="../js/jquery-1.11.1.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>
