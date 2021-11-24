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
			<h1 class="blogtitle">블로그 제목</h1>
			<h2 class="blogtag">tag</h2>
		</div>
	</center>
	<hr>
	<br>
	<br>
	<br>
	<div>
		<div style="width: 60%; float: left;">
			<table width="720" cellpadding="0" cellspacing="0">
				<tr>
					<td class="posttitle" align="left"><a href="#"><b>포스트
								제목</b></a></td>
					<td class="posttag" align="right"><a href="#"><b>edit</b></a>/<a
						href="#"><b>del</b></a></td>
				</tr>
				<tr>
					<td class="postdate" align="left">포스트 날짜</td>
				</tr>
				<tr>
					<td class="postcontent" align="left">포스트 내용</td>
				</tr>
				<tr>
					<td width="36%" height="20">&nbsp;</td>
					<td class="postwriter" align="right">포스트 작성자</td>
				</tr>
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
					<td class="tablecontent" align="center"><a href="blogadmin_basicView?user_id=${user.user_id }"><b>블로그 관리</b></a></td>
				</tr>
				<tr>
					<td class="tablecontent" align="center"><img height="100"
						src="images/j2eelogo.jpg" border="0"></td>
				</tr>
				<tr>
					<td class="categorytitle" align="center">카테고리</td>
				</tr>
				<tr>
					<td class="categoryitem" align="center"><a href="#"><b>미분류</b></a></td>
				</tr>
			</table>
		</div>

	</div>
</body>
</html>