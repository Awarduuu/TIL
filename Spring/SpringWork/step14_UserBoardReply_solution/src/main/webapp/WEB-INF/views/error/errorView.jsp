<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
  response.setStatus(200);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
<div class="container" >
<h3 style="padding:30px; text-align: center">
  Message : <span style="color:red">${exception.message}</span>
</h3>
<h4 style="text-align: center;">
   <a href="javascript:history.back()">뒤로가기</a> &nbsp;&nbsp;&nbsp;
   <a href="${pageContext.request.contextPath}/">홈으로</a>
</h4>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>	
</body>
</html>