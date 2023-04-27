<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>가입 결과</h1>

<h3>
	아이디 : ${dto.id} <br>
	이름 : ${dto.name} <br>
	나이 : ${dto.age } <br>
	주소 : ${dto.addr } <br>
</h3>

취미 : ${hobbys} <br>
정보 : ${info}

<hr>
<fieldset>
	<legend>취미</legend>
		<c:forEach items="${hobbys}" var="h">
			<input type="checkbox" name="hobbys" value="${h}">${h}
		</c:forEach>
</fieldset>

</body>
</html>