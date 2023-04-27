<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="navbar">
  <ul>
    <li class="nav-item logo"><a href="${pageContext.request.contextPath}/"><img src="${pageContext.request.contextPath}/resources/img/logo.jpg" alt=""></a></li>
   <li class="nav-item"><a href="${pageContext.request.contextPath}/personal/personal">개인</a></li>
    <li class="nav-item"><a href="${pageContext.request.contextPath}/business">기업</a></li>
    
    
  <c:choose>
    <c:when test="${ sessionScope.userDto==null}">
        <li class="nav-item"><a href="${pageContext.request.contextPath}/login">로그인</a></li>
        <li class="nav-item"><a href="${pageContext.request.contextPath}/registerForm">회원가입</a></li>
    </c:when>
    <c:otherwise>
        <li class="nav-item"><a href="javascript:logout('${pageContext.request.contextPath}');">로그아웃</a></li>
    </c:otherwise>
  </c:choose> 
    


    
  </ul>
</div>