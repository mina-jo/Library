<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/include/scriptFile.jsp" %>
</head>
<body>
	${memberList} dd
	<br />
	<br />
	<table border="1">
		<c:forEach var="data" items="${memberList}" varStatus="status">
			<tr>
				<td>${data.memberId}</td>
				<td>${data.email}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>