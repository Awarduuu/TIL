<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>1.레코드 삽입</h4>
<form method="post" action="${pageContext.request.contextPath}/insert">
    <table cellspacing="0">
		<tr bgcolor="pink" >
		    <th >상품코드</th>
			<th >상품이름</th>
			<th  >수량</th>
			<th  >가격</th>	
			<th  >설명</th>
		</tr>
		<tr>
		    <td><input type="text" size="8" name="code"> </td>
			<td><input type="text" size="8" name="name" ></td>
			<td><input type="text" size="4" name="qty" ></td>
			<td><input type="text" size="8" name="price"></td>
			<td><textarea name="detail" cols="20" rows="3"></textarea></td>
		</tr>
		<tr>
			<td colspan="5" align="center"> 
				<input type="submit" value="등록하기">
			</td>
		</tr>
	</table>
</form>
</body>
</html>