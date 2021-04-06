<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<td>ID_Book</td>
				<td>Book title</td>
				<td>author</td>
				<td>price</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${book_list}" var="itm">
				<tr>
					<td>${itm.id}</td>
					<td>${itm.title}</td>
					<td>${itm.author}</td>
					<td>${itm.id}</td>
				</tr>
			</c:forEach>

		</tbody>

	</table>


</body>
</html>