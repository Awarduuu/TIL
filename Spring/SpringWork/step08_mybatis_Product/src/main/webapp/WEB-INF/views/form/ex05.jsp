<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>5. 파라미터 값을 받아 업데이트하기</h4>
<form method="post" action="${pageContext.request.contextPath}/update">
    <table cellspacing="0">
		<tr bgcolor="pink" >
		    <th >수정할 상품코드</th>
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
				<input type="submit" value="수정하기">
			</td>
		</tr>
	</table>
</form>
</body>
</html>