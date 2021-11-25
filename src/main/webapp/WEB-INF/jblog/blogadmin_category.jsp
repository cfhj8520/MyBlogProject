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
					<td><a href="blogadmin_basicView?user_id=${user.user_id }">기본설정</a>&nbsp;</td>
					<td><a href="getCategoryList">카테고리</a>&nbsp;</td>
					<td><a href="blogadminView">글작성</a>&nbsp;</td>
					<td><a href="blogDeleteReq?user_id=${user.user_id }">삭제요청</a>&nbsp;</td>
				</tr>
			</table>
			<br>
			<center>
				<table width="720" border="1" cellpadding="0" cellspacing="0">
					<tr height="30">
						<td width="50" class="tablelabel">번호</td>
						<td width="100" class="tablelabel">카테고리 명</td>
						<td width="100" class="tablelabel">보이기 유형</td>
						<td width="100" class="tablelabel">포스트 수</td>
						<td width="300" class="tablelabel">설명</td>
						<td width="100" class="tablelabel">삭제</td>
					</tr>
					<c:forEach var="category" items="${categoryList }">
						<tr>
							<td class="tablecontent" align="center">${category.category_id }</td>
							<td class="tablecontent">${category.category_name }</td>
							<td class="tablecontent" align="center">${category.display_type }</td>
							<td class="tablecontent" align="center">${category.cnt_display_post }</td>
							<td class="tablecontent">${category.description }</td>
							<td class="tablecontent" align="center"><a href="#"><img height="9" src="images/delete.jpg" border="0"></a></td>
						</tr>
					</c:forEach>
				</table>
				<br><hr><br>

				<form action="createCategory" method="post">
					<table>
						<tr>
							<td align="right">카테고리명 :&nbsp;</td>
							<td><input type="text" name="category_name" size="50"></td>
						</tr>
						<tr>
							<td align="right">보이기 유형 :&nbsp;</td>
							<td>
								<input type="radio" name="display_type" value="제목"  checked="checked">제목&nbsp;&nbsp; 
								<input type="radio"	name="display_type" value="제목+내용">제목+내용
							</td>
						</tr>
						<tr>
							<td align="right">포스트 수 :&nbsp;</td>
							<td><input type="text" name="cnt_display_post" size="5">개(1~20)</td>
						</tr>
						<tr>
							<td align="right">설명 :&nbsp;</td>
							<td><input type="text" name="description" size="70"></td>
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
					<td class="tablecontent" align="center"><a href="blogmainView"><b>내
								블로그 메인</b></a></td>
				</tr>
			</table>
		</div>

	</div>
</body>
</html>