<%@page contentType="text/html; charset=EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�� ��α�</title>
<Link rel="stylesheet" href="css/theme.css">
</head>
<body>
	<center>
		<div class="box">
			<h1 class="blogtitle">��α� ����</h1>
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
					<td class="posttitle" align="left"><a href="#"><b>����Ʈ
								����</b></a></td>
					<td class="posttag" align="right"><a href="#"><b>edit</b></a>/<a
						href="#"><b>del</b></a></td>
				</tr>
				<tr>
					<td class="postdate" align="left">����Ʈ ��¥</td>
				</tr>
				<tr>
					<td class="postcontent" align="left">����Ʈ ����</td>
				</tr>
				<tr>
					<td width="36%" height="20">&nbsp;</td>
					<td class="postwriter" align="right">����Ʈ �ۼ���</td>
				</tr>
			</table>
		</div>
		<div style="width: 30%; float: right;">
			<table id="tdl2">
				<tr>
					<c:if test="${user == null }">
					<td class="tablecontent" align="center"><a href="loginView"><b>�α���</b></a></td>
					</c:if>
					<c:if test="${user != null }">
					<td class="tablecontent" align="center"><a href="logout"><b>�α׾ƿ�</b></a></td>
					</c:if>
					<td class="tablecontent" align="center"><a href="blogadmin_basicView?user_id=${user.user_id }"><b>��α� ����</b></a></td>
				</tr>
				<tr>
					<td class="tablecontent" align="center"><img height="100"
						src="images/j2eelogo.jpg" border="0"></td>
				</tr>
				<tr>
					<td class="categorytitle" align="center">ī�װ�</td>
				</tr>
				<tr>
					<td class="categoryitem" align="center"><a href="#"><b>�̺з�</b></a></td>
				</tr>
			</table>
		</div>

	</div>
</body>
</html>