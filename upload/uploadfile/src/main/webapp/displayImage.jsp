<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="color: red;" align="center">Display Image Detail </h1> 
<div align="center">
<form action="DisplayImage" method="post" enctype="multipart/form-date">
Select Image
<input type="number" name="imageId">
<input type="submit" value="Add Image"> 
</form>
</div>
<hr>
<% String imgFileName = (String) request.getAttribute("img");
String imgId = (String) request.getAttribute("id");
%>
<div align="center">
<table border="5px" style="width: 600px">
<tr>
<th>Image Id</th>
<th>Image</th>
</tr>
<% if(imgFileName != "" && imgId !=""){ %>
<tr>
<td><%= imgId %></td>
<td><img src="images/<%= imgFileName %>" style="width: 300px; height: 250px; "> </td>
</tr>
<% } %>
</table>
</div>
</body>
</html>