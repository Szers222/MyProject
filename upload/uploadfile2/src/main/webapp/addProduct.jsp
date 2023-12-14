<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center" style="color: red;">ADD IMAGE DETAIL</h1>
<div align="center">
<form action="AddProduct" method="post" enctype="multipart/form-data">
<input type="text" name="title"><br></br><br></br>
Select Image:
<input type="file" name="image"><br></br><br></br>
<input type="submit" value="Add Image"> <br></br><br></br>
</form>
</div>
</body>
</html>