<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

<h3>HttpSession - 저장된 정보 조회하기</h3>

아이디 : <%=session.getAttribute("id") %><br>
메세지 : <%=session.getAttribute("message") %> <br>
주소 : <%=request.getAttribute("addr") %> <br>

<hr>

<h3>ServletContext - 저장된 정보 조회하기</h3>
application 메시지 : <%=application.getAttribute("message") %> <p>
application 나이 : <%=application.getAttribute("age") %> <p>


</body>

</html>

