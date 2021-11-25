<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<h1 class="blogtitle">${blog.title }</h1>
			<h2 class="blogtag">${blog.tag }</h2>
		</div>
	</center>
	<hr>
	<br>
	<div>
		<div style="width: 60%; float: left;">
			<table>
				<tr>
					<td><a href="blogadmin_basicView">기본설정</a>&nbsp;</td>
					<td><a href="getCategoryList">카테고리</a>&nbsp;</td>
					<td><a href="adminPost">글작성</a>&nbsp;</td>
					<td><a href="blogDeleteReq">삭제요청</a>&nbsp;</td>
				</tr>
			</table>
			<br>
			<center>

				<form action="createPost" method="post">
					<table>
						<tr>
							<td align="right">제목 :&nbsp;</td>
							<td><input type="text" name="title" size="50"></td>
							<td>
								<select name="category_id">
									<c:forEach var="category" items="${categoryList }">
										<option value="${category.category_id }">${category.category_name }</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td align="right">내용 :&nbsp;</td>
							<td><textarea name="content" rows="10" cols="70"></textarea></td>
						</tr>
					</table>
					<input type="submit" value="카테고리 추가">
				</form>

			</center>
		</div>
		<div style="width: 30%; float: right;">
			<table id="tdl2">
				<tr>
					<td class="tablecontent" align="center"><a href="logout"><b>로그아웃</b></a></td>
					<td class="tablecontent" align="center"><a href="getPostList?blog_id=${blog.blog_id }"><b>내
								블로그 메인</b></a></td>
				</tr>
			</table>
		</div>

	</div>
</body>
</html>