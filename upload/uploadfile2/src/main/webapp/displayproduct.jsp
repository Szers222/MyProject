<%@page import="core.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Product</title>
</head>
<body>
<h1 style="color:red" align="center">DISPLAY IMAGE DETAIL</h1>

<div align="center">

<form action="DisplayServlet" method="post">
   Enter Image Id :
   <input type="number" name="id">
   <input type="submit" value="Display Product">
</form>

</div>

<hr>

<body>
<%Product sanpham = (Product) request.getAttribute("sanpham"); %>
<div align="center">
    <h2><c:out value="${sanpham.id}" /></h2>
    <h3><c:out value="${sanpham.title}" /></h3>
    <img src="data:image/jpg;base64,${sanpham.base64Image}" width="240" height="300"/>
</div>
</body>
</html>
