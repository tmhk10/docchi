<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どっち</title>
</head>
<body>
  <p>画像を投稿してください。</p>
  <form action="/docchi/ImagePostServlet" enctype="multipart/form-data" method="post">
    １枚目：<input type="file" name="firstOne" required><br>
    ２枚目：<input type="file" name="secondOne" required><br>
    <input type="submit" value="投稿">
  </form>
</body>
</html>