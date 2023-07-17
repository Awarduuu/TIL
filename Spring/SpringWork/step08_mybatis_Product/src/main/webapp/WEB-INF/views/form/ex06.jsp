<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>6.삭제하기</h4>
<form method="post" action="${pageContext.request.contextPath}/delete">
   삭제상품코드 :  <input type="text"  name="code">
   <input type="submit" value="검색">
</form>
</body>
</html>