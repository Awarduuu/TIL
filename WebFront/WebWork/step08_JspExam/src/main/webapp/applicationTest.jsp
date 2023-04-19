<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<h1>ServletContext - application</h1>
<h3>
	application.getRealPath() = <%= application.getRealPath("/") %><br>
	application.getContextPath() = <%= application.getContextPath() %><br>
	
	<%
		// application영역에 정보 저장
		application.setAttribute("message", "졸지맙시다");
		application.setAttribute("age", 35);
	%>
	
	<hr>
	application 메시지 : <%=application.getAttribute("message") %> <p>
	application 나이 : <%=application.getAttribute("age") %> <p>
	
	<a href="sessionGet.jsp">정보 확인</a>
</h3>



</body>

</html>

