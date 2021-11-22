<%@page contentType="text/html; charset=EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!-- 
	EL(Expression Language)
	session�̳� request ���� ��ü�� ��ϵ� �����͸� JSP ���Ͽ��� �����ϱ� ���� ǥ����
	
	JSTL(JSP Standard Tag Library)
	JSP ���Ͽ��� if, for, switch ��� ���� �ڹ� �ڵ带 ��ü�ϱ� ���� �����Ǵ� ǥ�� �׼� �±�
	�ٸ� �ݵ�� taglib ������ �ʿ��ϴ�. (XML Namespace ��ϰ� ������ ����)
 -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�� ���</title>
</head>
<body>
<center>
<h1>�Խ� �� ���</h1>
<sec:authentication property="principal" var="user"/>
<h3><font color="red">${user.username }</font>�� �α��� ȯ���մϴ�...<a href="/member/logout">LOG-OUT</a></h3>

<!-- �˻� ���� -->

<form action="/board/getBoardList" method="post">
	<table border="1" cellpadding="0" cellspacing="0" width="700">
	<tr>
		<td align="right">
			<select name="searchCondition">
			<option value="TITLE" <c:if test="${search.searchCondition == 'TITLE' }">selected</c:if>>����</option>
			<option value="CONTENT" <c:if test="${search.searchCondition == 'CONTENT' }">selected</c:if>>����</option>
			</select>
			<input name="searchKeyword" type="text" value="${search.searchKeyword }"/>
			<input type="submit" value="�˻�"/>
		</td>
	</tr>
	</table>
</form>

<!-- �˻� ���� -->

<table border="1" cellpadding="0" cellspacing="0" width="700">
<tr>
	<th bgcolor="orange" width="100">��ȣ</th>
	<th bgcolor="orange" width="200">����</th>
	<th bgcolor="orange" width="150">�ۼ���</th>
	<th bgcolor="orange" width="150">�����</th>
	<th bgcolor="orange" width="100">��ȸ��</th>
</tr>

<c:forEach var="board" items="${boardList }">
<tr>
	<td>${board.seq }</td>
	<td align="left"><a href="/board/getBoard?seq=${board.seq }">${board.title }</a></td>
	<td>${board.writer }</td>
	<td><fmt:formatDate value="${board.regdate }" pattern="yyyy-MM-dd"/></td>
	<td>${board.cnt }</td>
</tr>
</c:forEach>

</table>
<br>
<a href="/board/insertBoardView">���� ���</a>
</center>
</body>
</html>

