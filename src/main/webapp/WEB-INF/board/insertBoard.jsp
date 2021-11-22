<%@page contentType="text/html; charset=EUC-KR"%>

<!-- 
	EL(Expression Language)
	session이나 request 내장 객체에 등록된 데이터를 JSP 파일에서 접근하기 위한 표현식
 -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>새글등록</title>
</head>
<body>
<center>
<h1>새글 등록하기</h1>
<h3><font color="red">${user.name}</font>님 로그인 환영합니다...<a href="/member/logout">LOG-OUT</a></h3>
<hr>
<form action="/board/insertBoard" method="post">
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td bgcolor="orange" width="70">제목</td><td align="left">
		<input type="text" name="title"/></td>
	</tr>
	<tr>
		<td bgcolor="orange">작성자</td><td align="left">
		<input type="text" name="writer" size="10"/></td>
	</tr>
	<tr>
		<td bgcolor="orange">내용</td><td align="left">
		<textarea name="content" cols="40" rows="10"></textarea></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<input type="submit" value=" 새글 등록 "/></td>
	</tr>
</table>
</form>
<hr>
</center>
</body>
</html>