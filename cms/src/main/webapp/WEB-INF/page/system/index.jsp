<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="../../common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>简单CMS后台应用</title>
<link href="${base }/style/dwz/themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="${base }/style/dwz/themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="${base }/style/dwz/themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
<link href="${base }/style/dwz/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>
<!--[if IE]>
<link href="themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->
<style type="text/css">
	#header{height:85px}
	#leftside, #container, #splitBar, #splitBarProxy{top:90px}
</style>

<!--[if lt IE 9]><script src="js/speedup.js" type="text/javascript"></script><script src="js/jquery-1.11.3.min.js" type="text/javascript"></script><![endif]-->
<!--[if gte IE 9]><!--><script src="${base }/style/jquery/jquery-2.1.4.min.js" type="text/javascript"></script><!--<![endif]-->

<script src="${base }/style/dwz/js/jquery.cookie.js" type="text/javascript"></script>
<script src="${base }/style/dwz/js/jquery.validate.js" type="text/javascript"></script>
<script src="${base }/style/dwz/js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="${base }/style/dwz/xheditor/xheditor-1.2.2.min.js" type="text/javascript"></script>
<script src="${base }/style/dwz/xheditor/xheditor_lang/zh-cn.js" type="text/javascript"></script>
<script src="${base }/style/dwz/uploadify/scripts/jquery.uploadify.min.js" type="text/javascript"></script>

<script src="${base }/style/dwz/bin/dwz.min.js" type="text/javascript"></script>
<script src="${base }/style/dwz/js/dwz.regional.zh.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	
	dwzInit();
	getMenu('${sId}') ;
	
	getContainer();
});

function dwzInit() {
	DWZ.init("${base }/style/dwz/dwz.frag.xml", {
		loginUrl:"login_dialog.html", loginTitle:"登录",	// 弹出登录对话框
		statusCode:{ok:200, error:300, timeout:301}, //【可选】
		keys: {statusCode:"statusCode", message:"message"}, //【可选】
		pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"themes"});
			setTimeout(function() {$("#sidebar .toggleCollapse div").trigger("click");}, 10);
		}
	});
}

function getMenu(sId) {
	
	$('#sidebar').innerHTML = '' ;
	$('#sidebar').load('${base }/admin/menu.htm?id='+sId);
}
function getContainer() {
	$('#container').load('${base }/admin/main.htm');
}

</script>

</head>
<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="logo" href="http://j-ui.com">标志</a>
				<ul class="nav">
					<li id="switchEnvBox"><a href="javascript:">（<span>北京</span>）切换城市</a>
						<ul>
							<li><a href="sidebar_1.html">北京</a></li>
							<li><a href="sidebar_2.html">上海</a></li>
							<li><a href="sidebar_2.html">南京</a></li>
							<li><a href="sidebar_2.html">深圳</a></li>
							<li><a href="sidebar_2.html">广州</a></li>
							<li><a href="sidebar_2.html">天津</a></li>
							<li><a href="sidebar_2.html">杭州</a></li>
						</ul>
					</li>
					<li><a href="donation.html" target="dialog" height="400" title="捐赠 &amp; DWZ学习视频">捐赠</a></li>
					<li><a href="changepwd.html" target="dialog" width="600">设置</a></li>
					<li><a href="http://www.cnblogs.com/dwzjs" target="_blank">博客</a></li>
					<li><a href="http://weibo.com/dwzui" target="_blank">微博</a></li>
					<li><a href="http://bbs.dwzjs.com" target="_blank">论坛</a></li>
					<li><a href="login.html">退出</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">蓝色</div></li>
					<li theme="green"><div>绿色</div></li>
					<li theme="red"><div>红色</div></li>
					<li theme="purple"><div>紫色</div></li>
					<li theme="silver"><div>银色</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul>
			</div>
		
			<div id="navMenu">
				<ul>
					<c:forEach items="${menus }" var="menu" varStatus="index">
						<li><a href="javascript:;" onclick="javascript:getMenu(${menu.sId});"><span>${menu.name }</span></a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div id="leftside">
		<div id="sidebar_s">
			<div class="collapse">
				<div class="toggleCollapse">
					<div></div>
				</div>
			</div>
		</div>
		<div id="sidebar">
		
		</div>
		</div>
		<div id="container" style="width: 1705px; left: 210px;">
		</div>
	</div>
	
	<div id="footer">Copyright &copy; 2010 <a href="demo_page2.html" target="dialog">前台学习</a></div>
		
</body>
</html>