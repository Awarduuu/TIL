<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

<h3>~.jsp 이동</h3>
<form method="post" action="encodingResult.jsp">
	이름 : <input type="test" name="name">
	<input type="submit" value="전송">
</form>

<hr>

<h3>Servlet 이동</h3>
<form method="post" action="encTest">
	이름 : <input type="test" name="name">
	<input type="submit" value="전송">
</form>

</body>

</html>

