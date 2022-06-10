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
 
  <c:forEach var="pair" items="${pairList}">
    <div class="box">
      <div class="pictures" onclick="opacity(this)">
        <a href="/docchi/VoteSaveServlet?id=${pair.id}&fileName=${pair.fileName1}&which=former">
    	  <img src="/docchi/upload/${pair.fileName1}">
        </a>
        <a href="/docchi/VoteSaveServlet?id=${pair.id}&fileName=${pair.fileName2}&which=latter">
    	  <img src="/docchi/upload/${pair.fileName2}">
        </a>     
      </div>
      <div class="numbers">${pair.vote1}票&emsp;${pair.vote2}票
      </div>
    </div>
  </c:forEach>
  
 
<script>
function opacity(obj) {
	obj.style.opacity = 0.3;	
}

</script> 
</body>
</html>