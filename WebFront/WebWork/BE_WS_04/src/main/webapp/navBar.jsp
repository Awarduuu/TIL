<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/navbar.css">
<link rel="stylesheet" href="css/footer.css">
</head>

<body>

<nav id="navbar">
    <!-- 5개의 메뉴생성 -->
      <ul>
        <li class="nav-item logo"><img src="images/logo.jpg" alt="로고입니다." ></li>
        <li class="nav-item"> <a href="personal.html">개인</a></li>
        <li class="nav-item"><a href="busines.html">기업</a></li>
        
        <c:choose>
        	<c:when test="${empty email}">
        		<li class="nav-item"><a href="login.jsp">로그인</a></li>
       			<li class="nav-item"><a href="register.jsp">회원가입</a></li>
        	</c:when>
        	<c:otherwise>
        		<li class="nav-item"><a id="Logout" onclick="logout">로그아웃</a></li>
        	</c:otherwise>
        </c:choose>
        
      </ul>
</nav>

</body>

</html>

