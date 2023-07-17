<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btn").click(function(){
			$.ajax({
				url:"${pageContext.request.contextPath}/ajax.do",
				type:"post",
				data: {email:"jang" , pwd : "1234"} ,
				dataType:"text",
				success: function(result){
					alert(result)
				},
				error : function(jqXHR, textStatus, errorThrown){
					alert("문제 발생 : " + jqXHR.status)
				}
				
			});
		})
	})
	
</script>
</head>
<body>
<h2>Ajax Test</h2>
<button id="btn">클릭</button>
</body>
</html>