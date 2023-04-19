<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

<%
	request.setCharacterEncoding("UTF-8");
	String addr="서울시 강북구...";
%>
<jsp:include page="header.jsp" />

<h1>여기는 main.jsp 문서입니다.</h1>
<h3>
	메인 주소 : <%=addr %>
</h3>
<jsp:include page="footer.jsp">
	<jsp:param value="<%=addr %>" name="addr"/>
</jsp:include>

</body>

</html>

