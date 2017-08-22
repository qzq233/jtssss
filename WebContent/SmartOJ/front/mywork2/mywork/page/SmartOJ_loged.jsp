<%@page language="java" contentType="text/html;charset = UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	String O_logState = (String)session.getAttribute("logState");
	System.out.println(O_logState);
	
	if(O_logState == null){
		response.sendRedirect("SmartOJ.jsp");
	}
%>

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
					<div class="col-md-6">
						<!--panel面板，里面放置一些控件，下同-->
						<div class="panel panel-primary">
							<!--panel面板的标题，下同-->
							<div class="panel-heading">
								<h3 class="panel-title">最新提醒</h3>
							</div>
							<!--panel面板的内容，下同-->
							<div class="panel-body">
								<div class="alert alert-warning" role="alert">
									<strong>提示</strong>题目2已更改，请同学确认
								</div>
								<div class="alert alert-success" role="alert">
									<strong>提示</strong>题目2:Colored Sticks已发布!
								</div>
								<div class="alert alert-success" role="alert">
									<strong>提示</strong>题目1:Finding Home已发布!
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-6">

						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title">我的任务</h3>
							</div>
							<div class="panel-body">
								<ul class="nav nav-pills nav-stacked" role="tablist">
									<li role="presentation"><a href="#"
										class="alert alert-info"> <span class="badge pull-right">4</span>
											软件工程
									</a></li>
									<li role="presentation"><a href="#"
										class="alert alert-info"> <span class="badge pull-right">3</span>
											问题求解
									</a></li>
									<li role="presentation"><a href="#"
										class="alert alert-info"> <span class="badge pull-right">4</span>
											计算机网络
									</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title">最新题目</h3>
							</div>
							<div class="panel-body">
								<table class="table table-striped">
									<thead>
										<tr>
											<th>#</th>
											<th>题目</th>
											<th>通过率</th>
											<th>提交者</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1</td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>2</td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>3</td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
									</tbody>
								</table>
								<p>
									<a class="btn btn-primary" href="#" role="button">查看详细&raquo;</a>
								</p>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title">进度</h3>
							</div>
							<div class="panel-body">
								<h3>
									<span class="label label-success">完成题目</span>
								</h3>

								<div class="progress progress-striped active">
									<div class="progress-bar progress-bar-success "
										role="progressbar" aria-valuenow="80" aria-valuemin="0"
										aria-valuemax="100" style="width: 60%">
										<span class="sr-only">60% Complete</span>
									</div>
								</div>
								<h3>
									<span class="label label-danger">总正确率</span>
								</h3>

								<div class="progress progress-striped active">
									<div class="progress-bar progress-bar-danger"
										role="progressbar" aria-valuenow="30" aria-valuemin="0"
										aria-valuemax="100" style="width: 30%">
										<span class="sr-only">30% Complete (danger)</span>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type = "text/javascript">
		lsetActive("l_mainPage");
	</script>

	<script src="../js/jquery-1.11.1.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>
