<%@page import="java.util.Random"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<form action="/BooksStore/Books" method="get">
Book name :
<input type="text" name="name"/>
<input type="submit" value="send book">

</form>
<!-- scriplet tag  -->
<% Date today= new Date(); 
String message1="to day is : "+today;
%>
<!-- expression tag -->
<%= message1 %>
<br>
<% Random random = new Random();  
int randint = random.nextInt(1000);
boolean test=(randint % 2)==0;
String message="";
if(test){
	message="You flipped Heads";
}
else{
	message="You flipped Tails";
}

%>
<%=message %>

</body>
</html>