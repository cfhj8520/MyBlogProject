<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	<hr><br>
	<div>
		<div style="width: 60%; float: left;">
			<table>
				<tr>
					<td><a href="blogadminView">기본설정</a>&nbsp;</td>
					<td><a href="blogadminView">카테고리</a>&nbsp;</td>
					<td><a href="blogadminView">글작성</a>&nbsp;</td>
					<td><a href="blogDeleteReq?user_id=${user.user_id }">삭제요청</a>&nbsp;</td>
				</tr>
			</table>
			<br>
			<center>
			<form action="updateBlog" method="post">
			<table>
				<tr>
					<td align="right">블로그 제목 :&nbsp;</td>
					<td><input type="text" name="title" size="65" value="${blog.title}"></td>
				</tr>
				<tr>
					<td align="right">블로그 태그 :&nbsp;</td>
					<td><input type="text" name="tag" size="65" value="${blog.tag}"></td>
				</tr>
				<tr>
					<td align="right">메인페이지 포스트 :&nbsp;</td>
					<td><input type="text" name="cnt_display_post" size="65" value="${blog.cnt_display_post}"></td>
				</tr>
				<tr>
					<td align="right">로고이미지 :&nbsp;</td>
					<td><img height="100" src="images/j2eelogo.jpg" border="0"></td>
				</tr>
			</table>
			<input type="submit" value="확인">
			</form>
			</center>
		</div>
		<div style="width: 30%; float: right;">
			<table id="tdl2">
				<tr>
					<td class="tablecontent" align="center"><a href="logout"><b>로그아웃</b></a></td>
					<td class="tablecontent" align="center"><a href="blogmainView"><b>내 블로그 메인</b></a></td>
				</tr>
			</table>
		</div>

	</div>
</body>
</html>