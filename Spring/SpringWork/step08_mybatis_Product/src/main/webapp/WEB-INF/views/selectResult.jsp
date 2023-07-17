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
 <h3>검색된 결과</h3>
  <table cellspacing="0">
		<tr bgcolor="pink" >
		    <th >수정할 상품코드</th>
			<th >상품이름</th>
			<th  >수량</th>
			<th  >가격</th>	
			<th  >설명</th>
		</tr>
		

 <c:forEach items="${productList}"  var="product">
     <tr>
		    <td>${product.code} </td>
			<td>${product.name}</td>
			<td>${product.qty}</td>
			<td>${product.price}</td>
			<td><textarea name="detail" cols="20" rows="3">${product.detail}</textarea></td>
		</tr>
 </c:forEach>
 	</table>
 	
<h3><a href="${pageContext.request.contextPath}/">홈으로</a></h3>
</body>
</html>