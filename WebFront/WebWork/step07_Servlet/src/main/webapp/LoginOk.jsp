<%@page import="kb.servlet.Customer" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인 성공</h2>
	
	<%
		Customer cu = (Customer)request.getAttribute("cu");
	%>
	
	<h3>
	이름: <%= cu.getName() %><br>
	나이: <%= cu.getAge() %><br>
	주소: <%= cu.getAddr() %><br>
	연락처: <%= cu.getPhone() %><br>
	
	접속자 ip = <%= request.getRemoteAddr() %>
	</h3>
</body>
</html>