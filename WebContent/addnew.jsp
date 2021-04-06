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
	<h1 class="title">Book Store</h1>

	<a href="index"><h4 class="subtittle">List of Books</h4> </a>
	<a href="new" name="urlnew"><h4 class="subtittle">Add new book
		</h4> </a>

	<form action="insert" method="get">
		<table>
			<tr>
				<td><label>Id Book :</label></td>
				<td><input type="number" name="id" /></td>
			</tr>
			<tr>
				<td><label>Title:</label></td>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<td><label>Author :</label></td>
				<td><input type="text" name="author" /></td>
			</tr>
			<tr>
				<td><label>price :</label></td>
				<td><input type="number" name="price" /></td>
			</tr>
			<tr>
				<td><input type="reset" value="RESET" /></td>
				<td><input type="submit" value="ADD" /></td>
			</tr>
		</table>

	</form>
 

</body>
</html>