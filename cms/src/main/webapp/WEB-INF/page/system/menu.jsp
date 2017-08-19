<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="../../common/header.jsp"%>
<div class="toggleCollapse">
	<h2>主菜单</h2>
	<div>收缩</div>
</div>
<div class="accordion" fillspace="sidebar">
	<c:forEach items="${menus }" var="menu">
		<div class="accordionHeader">
			<h2>
				<span>Folder</span>${menu.name }
			</h2>
		</div>
		<c:if test="${menu.chrildren.size()>0 }">
			<c:forEach items="${menu.chrildren }" var="ch1">
				<div class="accordionContent">
					<ul class="tree treeFolder">
						<li>
							<a href="tabsPage.html" target="navTab">${ch1.name }</a>
							<c:if test="${ch1.chrildren.size()>0 }">
								<ul>
									<c:forEach items="${ch1.chrildren }" var="ch2">
										<li><a href="main.html" target="navTab" rel="${ch2.name }">${ch2.name }</a></li>
									</c:forEach>
								</ul>
							</c:if>
						</li>
					</ul>
				</div>
			</c:forEach>
		</c:if>
	</c:forEach>
</div>
 

