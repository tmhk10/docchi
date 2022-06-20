<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どっち</title>
</head>
<body>
  <h1>新規登録</h1>
  <form action="/docchi/SignUpServlet" method="post">
	ユーザーネーム:<input type="text" name="name" required>&emsp;<span id="username"></span><br>
	パスワード:<input type="password" name="pass" required><br>
	性別:<label><input type="radio" name="sex" value="M" required>男性</label>
	    <label><input type="radio" name="sex" value="F">女性</label><br>
	生年月日:<select name="year" id="YEAR">
			<c:forEach var="i" begin="1922" end="2022" step="1"><option value="${i}">${i}</option></c:forEach></select>年
	       <select name="month" id="MONTH">
	       <c:forEach var="i" begin="1" end="12" step="1"><option value="${i}">${i}</option></c:forEach></select>月
	       <select name="day" id="DAY">
	       <c:forEach var="i" begin="1" end="31" step="1"><option value="${i}">${i}</option></c:forEach></select>日
	       &emsp;<span id="dob"></span>
	       <br>
	<input type="submit" value="登録">
  </form>
  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="/docchi/signUpjQuery.js"></script>

</body>
</html>