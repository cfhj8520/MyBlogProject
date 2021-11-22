<%@page contentType="text/html; charset=EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!-- 
	EL(Expression Language)
	session이나 request 내장 객체에 등록된 데이터를 JSP 파일에서 접근하기 위한 표현식
	
	JSTL(JSP Standard Tag Library)
	JSP 파일에서 if, for, switch 등과 같은 자바 코드를 대체하기 위해 제공되는 표준 액션 태그
	다만 반드시 taglib 설정이 필요하다. (XML Namespace 등록과 동일한 개념)
 -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글 상세</title>
</head>
<body>
<center>
<h1>게시 글 상세</h1>
<hr>
<form action="/board/updateBoard" method="post">
<input name="seq" type="hidden" value="${board.seq}"/>
<table border="1" cellpadding="0" cellspacing="0">
<tr>
	<td bgcolor="orange" width="70">제목</td>
	<td align="left"><input name="title" type="text" value="${board.title}"/></td>
</tr>
<tr>
	<td bgcolor="orange">작성자</td>
	<td align="left">${board.writer}</td>
</tr>
<tr>
	<td bgcolor="orange">내용</td>
	<td align="left"><textarea name="content" cols="40" rows="10">${board.content}</textarea></td>
</tr>
<tr>
	<td bgcolor="orange">등록일</td>
	<td align="left">${board.regdate}</td>
</tr>
<tr>
	<td bgcolor="orange">조회수</td>
	<td align="left">${board.cnt}</td>
</tr>
<tr>
	<td colspan="2" align="center">
		<input type="submit" value="글 수정"/>
	</td>
</tr>
</table>
</form>
<hr>
<a href="/board/insertBoardView">글등록</a>&nbsp;&nbsp;&nbsp;
<sec:authorize access="hasRole('ROLE_ADMIN')">
<a href="/board/deleteBoard?seq=${board.seq}">글삭제</a>&nbsp;&nbsp;&nbsp;
</sec:authorize>
<a href="/board/getBoardList">글목록</a>
</center>
</body>
</html>
