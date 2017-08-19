<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
	<title>登陆</title>
	<link href="${base }/style/backend/css/bootstrap.min.css" title="" rel="stylesheet" />
	<link title="orange" href="${base }/style/backend/css/login.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="${base }/style/jquery/jquery-1.9.0.js"></script>
	<script type="text/javascript">
		function sys_login() {
			
			 $.post('${base}/admin/login', $("#LoginForm").serialize(),function(data) {
				 
 				if (data.code == '200') {
 					LoginForm.submit();
 				} else {
 					alert(data.message);
 				}
 			}) ;
		}
	</script>
</head>
<body>
<div style="height:1px;"></div>
  <div class="login">
     <header>
	    <h1>登陆</h1>
	 </header>
	 <div class="sr">
	    <form id="LoginForm" name="LoginForm" action="${base}/admin/index" method="post">
		    <div class="name">
				<label>
				<i class="sublist-icon glyphicon glyphicon-user"></i>
				</label>
				<input type="text"  placeholder="这里输入登录名" class="name_inp" name="username">
			</div>
			 <div class="name">
				<label>
				<i class="sublist-icon glyphicon glyphicon-pencil"></i>
				</label>
				<input type="password"  placeholder="这里输入登录密码" class="name_inp" name="password">
			</div>
			<input type='button' class="dl" onclick="sys_login()" value='登陆' />
		</form>
	 </div>
  </div>

</body>
</html>