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
	게시물 상세조회
	<c:if test="${empty board}">
		게시물이 존재하지 않음
	</c:if>
	<c:if test="${!empty board}">
	<ul>
		<li>${board.title}</li>
		<li>${board.content}</li>
		<li>${board.writer}</li>
		<li>${board.regDate}</li>
		<li>${board.updateDate}</li>
	</ul>	
	</c:if>
</body>
</html>