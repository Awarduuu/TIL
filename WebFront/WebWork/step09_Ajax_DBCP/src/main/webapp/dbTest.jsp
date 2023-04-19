<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="web.dao.MemberDAOImpl"%>
<%@page import="web.dao.MemberDAO"%>
<%@page import="java.util.List"%>
<%@page import="web.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		border : double red 5px;
		width : 800px;
	}
	th, td{
		padding: 3px;
		border: 1px gray solid;
		text-align: center;		
	}
</style>
</head>

<body>

<h1> DBCP TEST </h1>
<%
	MemberDAO dao = new MemberDAOImpl();
	List<Member> list = dao.selectAll();
	request.setAttribute("list", list);
%>

<table>
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>이름</th>
		<th>나이</th>
		<th>주소</th>
	</tr>
	<c:choose>
	<c:when test="${empty requestScope.list || list.size() == 0}">
		<tr>
			<th colspan="5">검색된 정보가 없습니다.</th>
		</tr>
	</c:when>
	<c:otherwise>
		<c:forEach items="${list}" var="mem" varStatus="state">
			<tr>
				<td>${state.count}</td>
				<td>${mem.id}</td>
				<td>${mem.name}</td>
				<td>${mem.age }</td>
				<td>${mem.addr }</td>
			</tr>
		</c:forEach>
	</c:otherwise>
	</c:choose>
</table>

<hr>

<h3> Map &lt; c:forEach> 사용하기</h3>

<%
	Map<String, String> map = new HashMap<>();
	map.put("kr", "대한민국");
	map.put("fr", "프랑스");
	map.put("uk", "영국");
	map.put("jp", "일본");
	map.put("sp", "스페인");
	
	request.setAttribute("map", map); // ${map} 사용
	request.setAttribute("price", "2500000000");
%>

<fieldset>

	<legend>나라선택</legend>
	
	<c:forEach items="${map}" var="nation">
		<input type="radio" name="nation" value="${nation.key}">${nation.value}
	</c:forEach>

</fieldset>


<hr>

가격 : 
<fmt:formatNumber value="${price}"/> 원

<p>
appication.getContextPath() = <%=application.getContextPath() %> <br>
\${pageContext.request.contextPath} = ${pageContext.request.contextPath}

</body>

</html>

