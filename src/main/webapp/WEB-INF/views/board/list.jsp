<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시물 리스트</h1>
	<c:forEach var="board" items="${list}">
	<ul>
		<li>${board.title}</li>
		<li>${board.content}</li>
		<li>${board.writer}</li>
		<li>${board.regDate}</li>
		<li>${board.updateDate}</li>
	</ul>
	<br><hr>
	</c:forEach>
</body>
</html>