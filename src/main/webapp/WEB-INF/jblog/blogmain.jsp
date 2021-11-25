<%@page contentType="text/html; charset=EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>의 블로그</title>
<Link rel="stylesheet" href="css/theme.css">
</head>
<body>
	<center>
		<div class="box">
			<h1 class="blogtitle">${blog.title }</h1>
			<h2 class="blogtag">${blog.tag }</h2>
		</div>
	</center>
	<hr>
	<br>
	<br>
	<br>
	<div>
		<div style="width: 60%; float: left;">
			<table width="720" cellpadding="0" cellspacing="0">
				<c:forEach var="post" items="${postList }">
					<tr>
						<td class="posttitle" align="left"><a href="#"><b>${post.title }</b></a></td>
						<td class="posttag" align="right"><a href="adminPost?post_id=${post.post_id }"><b>edit</b></a>/<a href="#"><b>del</b></a></td>
					</tr>
					<tr>
						<td class="postdate" align="left">${post.created_date }</td>
					</tr>
					<tr>
						<td class="postcontent" align="left">${post.content }</td>
					</tr>
					<tr>
						<td width="36%" height="20">&nbsp;<hr></td>
						<td class="postwriter" align="right">blog.user_name<hr></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div style="width: 30%; float: right;">
			<table id="tdl2">
				<tr>
					<c:if test="${user == null }">
					<td class="tablecontent" align="center"><a href="loginView"><b>로그인</b></a></td>
					</c:if>
					<c:if test="${user != null }">
					<td class="tablecontent" align="center"><a href="logout"><b>로그아웃</b></a></td>
					</c:if>
					<c:if test="${user.id != null && user.user_id == blog.blog_id }">
					<td class="tablecontent" align="center"><a href="blogadmin_basicView"><b>블로그 관리</b></a></td>
					</c:if>
				</tr>
				<tr>
					<td class="tablecontent" align="center"><img height="100"
						src="images/j2eelogo.jpg" border="0"></td>
				</tr>
				<tr>
					<td class="categorytitle" align="center">카테고리</td>
				</tr>
				<c:forEach var="category" items="${categoryList }">
					<tr>
						<td class="categoryitem" align="center"><a href="getPostList?category_id=${category.category_id }&blog_id=${blog.blog_id}"><b> ${category.category_name }</b></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</div>
</body>
</html>