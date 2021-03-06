<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog 홈</title>
<Link rel="stylesheet" href="css/theme.css">
</head>
<body>
<center>
<form action="getBlogList" method="post">
<table width="100%" height=320 border="0" cellpadding="0" cellspacing="0">
<tr><td height=40 colspan="10">&nbsp;</td></tr>
<tr>
	<td width="100%" height="120" colspan="10" align="center">
		<img src="images/logo.jpg" border="0">
	</td>
</tr>
<tr>
	<td width="30%" height="30">&nbsp;</td>
	<td width="70%" colspan="2">
		<!-- 로그인 성공하지 않은 경우 -->
		<c:if test="${user == null }">
		<a href="loginView"><b>로그인</b></a>&nbsp;&nbsp;
		</c:if>
		<!-- 로그인 성공한 경우 -->
		<c:if test="${user != null && !hasBlog}">
		<a href="blogcreateView"><b>블로그등록</b></a>&nbsp;&nbsp;
		</c:if>
		<c:if test="${user != null && hasBlog}">
		<a href="getPostList?blog_id=${user.user_id }"><b>내 블로그로 가기</b></a>
		</c:if>
	</td>
</tr>
<tr>
	<td width="36%" height="20">&nbsp;</td>
	<td width="64%"><input type="text" name="searchKeyword" size="65"><input type="submit" value="검색"></td>
</tr>
<tr>
	<td height="20" colspan="10" align="center" class="tdcontent">
		<input type="radio" name="searchCondition" value="TITLE"  checked="checked">블로그 제목&nbsp;&nbsp; 
		<input type="radio"	name="searchCondition" value="TAG">태그&nbsp;&nbsp; 
		<input type="radio" name="searchCondition" value="BLOGGER">블로거
	</td>
</tr>
</table>
</form>
<c:if test="${blogList.size() > 0 }">
<table width="720" border="1" cellpadding="0" cellspacing="0">
<tr height="50">
	<td width="320" class="tablelabel">블로그 제목</td>
	<td width="100" class="tablelabel">블로거</td>
	<td width="100" class="tablelabel">로고</td>
	<td width="100" class="tablelabel">상태</td>
	<c:if test="${user.role == 'ADMIN'}">
	<td width="100" class="tablelabel">삭제</td>
	</c:if>
</tr>
<c:forEach var="blog_one" items="${blogList }">
<tr height="50">
	<td class="tablecontent">&nbsp;&nbsp;&nbsp;<a href="getPostList?blog_id=${blog_one.user_id }">${blog_one.title }</a></td>
	<td class="tablecontent" align="center">${blog_one.user_name }</td>
	<td class="tablecontent" align="center"><img height="32" src="images/j2eelogo.jpg" border="0"></td>
	<td class="tablecontent" align="center">${blog_one.status }</td>
	<c:if test="${user.role == 'ADMIN'}">
	<td class="tablecontent" align="center">
		<a href="deleteBlog?blog_id=${blog_one.blog_id}"><img height="9"	src="images/delete.jpg" border="0"></a>
	</td>
	</c:if>
</tr>
</c:forEach>
</table>
</c:if>
</center>
</body>
</html>