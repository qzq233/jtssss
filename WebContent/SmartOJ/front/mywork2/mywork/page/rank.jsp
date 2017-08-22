<%@page language="java" contentType="text/html;charset = UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>SmartOJ_problemlist</title>
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

<body>
	<!-- 顶部导航栏 -->
	<%@ include file="component/header.jsp"%>
	<!-- 模态登录弹出框 -->
	<%@ include file="component/loginfile.jsp"%>
	<!--自适应布局-->
	<div class="container-fluid">
		<div class="row">
			<!-- 左侧导航栏-->
			<%@ include file="component/leftnav.jsp"%>
			<!--右侧问题列表-->
			<%@ include file="component/problemlist.jsp"%>
		</div>
	</div>

	<script type = "text/javascript">
	lsetActive("l_rank");
	</script>
	<script src="../js/jquery-1.11.1.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<!--<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>-->
</body>
</html>
