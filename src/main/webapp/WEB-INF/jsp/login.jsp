<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どっち</title>
</head>
<body>
  <h1>ログイン</h1>
  <div align="right">
  	<a href="/docchi/SignUpServlet">新規登録はこちら</a>&emsp;
  </div>
  <form action="/docchi/LoginServlet" method="post">
	ユーザーネーム:<input type="text" name="name"><br>
	パスワード:<input type="password" name="pass"><br>
	<input type="submit" value="入力終了">
  </form>
</body>
</html>