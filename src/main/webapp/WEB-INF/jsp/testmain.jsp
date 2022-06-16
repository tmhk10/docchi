<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>どっち</title>
	<link rel="stylesheet" type="text/css" href="/docchi/testmain.css" />
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
      <div class="pictures">
        <form action="/docchi/VoteSaveServlet?id=${pair.id}&fileName=${pair.fileName1}&which=former" id="pictinfo">
    	  <input type="image" src="/docchi/upload/${pair.fileName1}" alt="送信する" id="pict">    	  
        </form>
        <form action="/docchi/VoteSaveServlet?id=${pair.id}&fileName=${pair.fileName2}&which=latter" id="pictinfo">
    	  <input type="image" src="/docchi/upload/${pair.fileName2}" alt="送信する" id="pict" >
        </form>     
      </div>
      <div class="numbers">${pair.vote1}票&emsp;${pair.vote2}票
      </div>
    </div>
  </c:forEach>
  
 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="/docchi/testjQuery.js"></script> 

</body>
</html>