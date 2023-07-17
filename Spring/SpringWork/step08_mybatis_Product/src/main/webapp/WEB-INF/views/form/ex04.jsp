<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>4. 정렬대상 컬럼을 인수로 받아 정렬</h4>
<form method="post" action="${pageContext.request.contextPath}/selectByOrder">
   정렬컬럼 :  <input type="text"  name="columnName">
   <input type="submit" value="검색">
</form>
</body>
</html>