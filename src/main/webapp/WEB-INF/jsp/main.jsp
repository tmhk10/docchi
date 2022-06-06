<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>どっち</title>
	<link rel="stylesheet" type="text/css" href="/docchi/main.css" />
</head>
<body>
  <h1>どっち？</h1>
  <c:choose>
    <c:when test="${empty login}">
      <div align="right">
        ※画像投稿にはログインが必要です。　<a href="/docchi/LoginServlet">ログイン</a>
      </div>
    </c:when>
    <c:otherwise>
      <div align="right">
    	※ログイン中です。　<a href="/docchi/LogoutServlet">ログアウト</a>　　
    	<a href="/docchi/ImagePostServlet">画像投稿</a>
  	  </div>
    </c:otherwise>
  </c:choose>  
 
  <c:forEach var="pair" items="${pairList}" >
    <p class="pictures"><img src="/docchi/upload/${pair.fileName1}"><img src="/docchi/upload/${pair.fileName2}"></p>
  </c:forEach>
 
</body>
</html>