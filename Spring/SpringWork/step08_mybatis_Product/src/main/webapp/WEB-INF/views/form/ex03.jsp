<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>3. 검색필드 , 검색단어에 해당하는 레코드 검색</h4>
<form method="post" action="${pageContext.request.contextPath}/selectByKeyWord">
   <select name="keyField">
      <option value="0">--선택--</option>
      <option value="code">code</option>
     <option value="name">name</option>
     <option value="detail">detail</option>
   </select>
    <input type="text"  name="keyWord">
   <input type="submit" value="검색">
</form>
</body>
</html>