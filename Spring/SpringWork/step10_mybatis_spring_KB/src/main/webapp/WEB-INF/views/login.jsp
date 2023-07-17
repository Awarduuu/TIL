<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
	String contextPath = request.getContextPath();
--%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/navbar.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}//resources/css/footer.css">
  <style>

    #login {
      margin-top: 5px;
      padding: 20px 0px;
    }

    #login h1 {
      padding: 5px;
      text-align: center;
    }

    #login form{
      display: block;
      width: 100%;
      height: 200px;
      border: 1px solid lightgrey;
      padding: 40px;
    }

    #login .form-item{
      margin-bottom: 10px;
    }

    #login .form-item label{
      display: inline-block;
      width: 100px;
      font-size: 18px;
    }

    #login .form-item input{
      display: inline-block;
      width: 200px;
      font-size: 18px;
    }

    #login button{
      margin-top: 10px;
      padding: 5px;
      float: right;
      width: 80px;
      font-size: 18px;
    } 
  </style>
  <title>IT's KB - login</title>
</head>
<body>
  <div id="container">
  
    <!-- navBar 로 대체 -->
  	<jsp:include page="/WEB-INF/views/navBar.jsp" flush="true"/>
  	
    <div id="banner">지금 당신의 행복! IT's KB Life!</div>
    <div id="login">
      <h1>Login</h1>
		<form action="">
        <div class="form-item">
          <label for="email">이메일</label>
		      <input type="text" id="email">
        </div>

        <div class="form-item">
          <label for="password">비밀번호</label>
		      <input type="password" id="password">
        </div>

        <hr>
        <button id="btnLogin">로그인</button>
		</form>
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
    	 getBanner('${pageContext.request.contextPath}');
    	 
    	 
    	 $("#btnLogin").click(function(e){
    		 e.preventDefault();
    		 if($("#email").val()==""){
    	   			alert("이메일를 입력해주세요.");
    	   			$("#email").focus();
    	   			return false;
    	   		}
    	   		
    	   		if($("#password").val()==""){
    	   			alert("비밀번호를 입력해주세요.");
    	   			$("#password").focus();
    	   			return false;
    	   		}
    	   		
    	   		
    		 let id =   $("#email").val() ;
     		 let pwd =   $("#password").val();
     		 
     		console.log(id)
    		console.log(pwd)
    		
    		$.ajax({
        		url:"${pageContext.request.contextPath}/login",
        		type:"post",
        		data: {email:$("#email").val() , pwd : $("#password").val() } ,
        		dataType:"text",
        		success: function(data, status, xhr){
        			console.log("login data = " + data);
        			if(data=="success"){
        				
        				window.location.href="${pageContext.request.contextPath}/"
        			}else{
            			alert("정보를 다시 확인해주세요.");
            			
            			$("input").val("")
            			$("#email").focus();
        			}
        		},
        		error : function(jqXHR, textStatus, errorThrown){
        			alert("문제 발생 : " + jqXHR.status)
        		}
        		
        	});
     		
     		return false;
     		
    	 });//클릭끝
    	 
     })
   
   </script>
  
  

</body>
</html>