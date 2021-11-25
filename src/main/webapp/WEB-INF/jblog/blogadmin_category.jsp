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
							<c:if test="${category.category_name.equals('미분류') }">
								<td class="tablecontent">미분류</td>
							</c:if>
							<c:if test="${!category.category_name.equals('미분류') }">
								<td class="tablecontent"><a href="getCategoryList?category_id=${category.category_id }">${category.category_name }</a></td>
							</c:if>
							<td class="tablecontent" align="center">${category.display_type }</td>
							<td class="tablecontent" align="center">${category.cnt_display_post }</td>
							<td class="tablecontent">${category.description }</td>
							<td class="tablecontent" align="center">
								<c:if test="${category.category_name.equals('미분류') }">
									삭제불가
								</c:if>
								<c:if test="${!category.category_name.equals('미분류') }">
									<a href="deleteCategory?category_id=${category.category_id }">
										<img height="9" src="images/delete.jpg" border="0">
									</a>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</table>
				<br><hr><br>
				<c:if test="${selected_category == null }">
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
				</c:if>
				<c:if test="${selected_category != null }">
					<form action="updateCategory" method="post">
						<input type="hidden" name="category_id" value="${selected_category.category_id }">
						<table>
							<tr>
								<td align="right">카테고리명 :&nbsp;</td>
								<td><input type="text" name="category_name" size="50" value="${selected_category.category_name }"></td>
							</tr>
							<tr>
								<td align="right">보이기 유형 :&nbsp;</td>
								<td>
									<c:if test="${selected_category.display_type.equals('제목') }">
										<input type="radio" name="display_type" value="제목" checked="checked">제목&nbsp;&nbsp; 
										<input type="radio"	name="display_type" value="제목+내용">제목+내용
									</c:if>
									<c:if test="${selected_category.display_type.equals('제목+내용') }">
										<input type="radio" name="display_type" value="제목">제목&nbsp;&nbsp; 
										<input type="radio"	name="display_type" value="제목+내용" checked="checked">제목+내용
									</c:if>
								</td>
							</tr>
							<tr>
								<td align="right">포스트 수 :&nbsp;</td>
								<td><input type="text" name="cnt_display_post" size="5" value="${selected_category.cnt_display_post }">개(1~20)</td>
							</tr>
							<tr>
								<td align="right">설명 :&nbsp;</td>
								<td><input type="text" name="description" size="70" value="${selected_category.description }"></td>
							</tr>
						</table>
						<input type="submit" value="카테고리 수정">
					</form>
				</c:if>
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