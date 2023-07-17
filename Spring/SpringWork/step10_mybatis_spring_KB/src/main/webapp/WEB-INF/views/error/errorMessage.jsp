<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<% response.setStatus(200);%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/navbar.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer.css">

 <style type="text/css">
   .err{
     height: 200px;vertical-align: middle;
      display: table-cell;
     padding: 30px; color: red
   }
   a{text-decoration: none}
 </style>
  <title>IT's KB - 개인</title>
</head>
<body>
  <div id="container">
  
    <!-- navBar 로 대체 -->
  	<jsp:include page="/WEB-INF/views/navBar.jsp" flush="true"/>
  	
  	<div id="banner">지금 당신의 행복! IT's KB Life!</div>
  	
  	<div class="err">
      <h3 >Error  : ${exception.message} </h3>
		
		<h4 style="margin-top: 20px; ">
		<a href="${pageContext.request.contextPath}/">홈으로</a>
		<a href="${pageContext.request.contextPath}/login">로그인</a>
		</h4>
    </div>

    
    
    
    <div id="footer">
      <ul>
        <li class="address">12345 address 1 address 2 address 3</li>
        <li class="phone">02-0000-0000</li>
      </ul>
    </div>
  </div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/common.js"></script>
   <script type="text/javascript">
     $(function(){
    	// common.js 에 앴는 function 호출
         getBanner('${pageContext.request.contextPath}');
         
    	
       
       
   });//readyEnd
   </script>
  

</body>
</html>