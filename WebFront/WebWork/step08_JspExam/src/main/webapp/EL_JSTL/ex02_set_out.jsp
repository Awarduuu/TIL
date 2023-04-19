<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<h3> &lt; c:out> and &lt;c:set> 알아보기</h3>
<c:out value="안녕"/><br>
<c:out value="<h3>안녕</h3>"/><br>
<c:out value="<h3>안녕</h3>" escapeXml="true"/><br>
<c:out value="<h3>안녕</h3>" escapeXml="false"/><br>

${"<h3>안녕</h3>"}

<hr>

<c:set var="id" value="jang"/>
<c:set var="age" value="20" scope="session"/>
<c:set var="addr" value="서울" scope="application"/>

<h4>출력해보자</h4>

아이디 : ${id}
나이 : ${age}
주소 : ${addr}

<a href="ex02_result.jsp">이동해보자</a>
</body>

</html>

