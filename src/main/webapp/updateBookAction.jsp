<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="book" class="in.purabtech.entity.Book" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="book"/>
<jsp:forward page="updateBookDetail"></jsp:forward>
</body>
</html>