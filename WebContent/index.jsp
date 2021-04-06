<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css">  
<title>Insert title here</title>
</head>
<body>
<h1 class="title">Book Store </h1>

 <a href="index"><h4 class="subtittle">List of Books </h4> </a> 
<a href="new" name="urlnew"><h4 class="subtittle"> Add new book </h4> </a>

	<table border="1" class="table">
		<thead>
			<tr>
				<th>ID_Book</th>
				<th>Book title</th>
				<th>author</th>
				<th>price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${book_list}" var="itm">
				<tr>
					<td>${itm.getId()}</td>
					<td>${itm.getTitle()}</td>
					<td>${itm.getAuthor()}</td>
					<td>${itm.getPrive()}</td>
				</tr>
			</c:forEach>

		</tbody>

	</table>


</body>
</html>