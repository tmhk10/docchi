<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どっち</title>
</head>
<body>
  <form action="/docchi/LoginServlet" method="post">
    <h1>ログイン</h1>
	ユーザーネーム:<input type="text" name="name"><br>
	パスワード:<input type="password" name="pass"><br>
	<input type="submit" value="入力終了">
  </form>
</body>
</html>