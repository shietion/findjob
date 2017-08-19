<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../common/header.jsp"%>
<div id="navTab" class="tabsPage">
	<div class="tabsPageHeader">
		<div class="tabsPageHeaderContent">
			<!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
			<ul class="navTab-tab" style="left: 0px;">
				<li tabid="main" class="main selected"><a href="javascript:;"><span><span
							class="home_icon">我的主页</span></span></a></li>
			</ul>
		</div>
		<div class="tabsLeft" style="display: none;">left</div>
		<!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
		<div class="tabsRight" style="display: none;">right</div>
		<!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
		<div class="tabsMore">more</div>
	</div>
	<ul class="tabsMoreList" style="display: none;">
		<li class="selected"><a href="javascript:;">我的主页</a></li>
	</ul>
	<div class="navTab-panel tabsPageContent layoutBox"
		style="height: 445px;">
		<div class="page unitBox" style="display: block;">
			<div class="accountInfo">
				<div class="alertInfo">
					<h2>
						<a href="doc/dwz-user-guide.pdf" target="_blank">DWZ框架使用手册(PDF)</a>
					</h2>
					<a href="doc/dwz-user-guide.swf" target="_blank">DWZ框架演示视频</a>
				</div>
				<div class="right">
					<p>
						<a href="doc/dwz-user-guide.zip" target="_blank"
							style="line-height: 19px">DWZ框架使用手册(CHM)</a>
					</p>
					<p>
						<a href="doc/dwz-ajax-develop.swf" target="_blank"
							style="line-height: 19px">DWZ框架Ajax开发视频教材</a>
					</p>
				</div>
				<p>
					<span>DWZ富客户端框架</span>
				</p>
				<p>
					DWZ官方微博:<a href="http://weibo.com/dwzui" target="_blank">http://weibo.com/dwzui</a>
				</p>
			</div>
			<div class="pageFormContent" layouth="80"
				style="height: 365px; overflow: auto;">
				<iframe width="100%" height="430" class="share_self" frameborder="0"
					scrolling="no"
					src="http://widget.weibo.com/weiboshow/index.php?width=0&amp;height=430&amp;fansRow=2&amp;ptype=1&amp;speed=300&amp;skin=1&amp;isTitle=0&amp;noborder=1&amp;isWeibo=1&amp;isFans=0&amp;uid=1739071261&amp;verifier=c683dfe7"></iframe>
			</div>
		</div>

	</div>
</div>