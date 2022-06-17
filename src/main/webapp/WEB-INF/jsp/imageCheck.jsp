<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>どっち</title>
  <link rel="stylesheet" type="text/css" href="/docchi/imageCheck.css" />
</head>
<body>
  <p>自分の投稿一覧</p>
  <div align="right">
  	<a href="/docchi/MainServlet">トップへ</a>
  	<a href="/docchi/MenuServlet">メニューへ戻る</a>
  </div>
  
  <c:forEach var="pair" items="${personalList}">
    <div class="box">
      <div class="pictures">
        <a tabindex="-2" id="pictinfo">
    	  <img src="/docchi/upload/${pair.fileName1}">
        </a>
        <a tabindex="-2" id="pictinfo">
    	  <img src="/docchi/upload/${pair.fileName2}">
        </a> 
        <button>削除</button>    
      </div>
      <div class="numbers" id="${pair.id}">${pair.vote1}票&emsp;${pair.vote2}票
      </div>
    </div>
  </c:forEach>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="/docchi/checkjQuery.js"></script> 

</body>
</html>