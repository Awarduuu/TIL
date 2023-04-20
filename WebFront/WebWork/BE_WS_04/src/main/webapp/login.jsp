<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<meta charset="UTF-8">

  <title>IT's KB - login</title>
  <link rel="stylesheet" href="css/common.css">
  <link rel="stylesheet" href="css/navbar.css">
  <link rel="stylesheet" href="css/footer.css">
  
  <style type="text/css">
     #login{
       padding: 20px 0;
     }
     #login h1{
       padding: 5px;
       text-align: center;
     }
     
     #login form{
    
       width: 100%;
       height: 200px;
       border: 1px solid gray;
       padding: 40px;
     }
     
     #login .form-item{
        margin-bottom: 10px;
     }
     
     #login .form-item label{
     display:inline-block;
       width: 100px;
       font-size: 18px;
     }
     
     #login .form-item input{
     display:inline-block;
       width: 200px;
       font-size: 18px;
     }
     
     #login button{
        float: right;
        width: 80px;
         font-size: 18px;
         padding: 5px;
     }
     
  </style>
  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
  <script type="text/javascript">
  
    $(function(){
    	
      getBanner("${pageContext.request.contextPath}");
      $("#btnLogin").click(function(e){
    	  let email = $("#email") ; //document.getElementById("email")
  		  let pwd = $("#password");//document.getElementById("password")
      
  		 if(email.val()==""){
			alert("이메일를 입력해주세요.");
			email.focus();
			return false;
		}
		
		if(pwd.val()==""){
			alert("비밀번호를 입력해주세요.");
			pwd.focus();
			return false;
		}
		//////////////////////////////////////////////////////////////
		//alert("모든정보가 있습니다.")
		$.ajax({
		    	url : "${pageContext.request.contextPath}/login", // 서버주소(요청주소)
		    	type: "post" , //요청방식 (get | post | put | delete )
		    	dataType : "json",  //서버가 응답할때 전달하는 데이터 타입 (text | html | xml | json)
		    	data : {email:email.val(), pwd:pwd.val()}, //서버에게 전달하는 parameter정보 
		    	success : function(data , status){//응답결과가 성공했을때 함수
		    	     if(data.result=="success"){
		    	    	 alert("로그인되었습니다.")
		    	    	 location.href = "${pageContext.request.contextPath}/index.jsp";
		    	     }else{
		    	    	 alert("로그인실패하였습니다.")
		    	    	 $("input").val("");
		    	    	 $("#email").focus();
		    	     }
		    	}, 
		    	error : function(err, status){//응답결과가 실패했을때 함수 
		    		// 에러발생....
		    		alert(err +"발생했습니다. status = " + status);
		    	} 
		    });
		/////////////////////////////////////////////////////////
	     e.preventDefault(); //return false;
      
      }); 
    	
    });//readyEnd
  
  
  
  
    
  
  </script>
</head>
<body>
<div id="container">
  <%@ include file="navBar.jsp" %>
    
    <div id="banner">지금 당신의 행복! IT's KB Life!</div> 
 
 <div id="login">
  <h1>Login</h1>
  <form action="http://www.naver.com" method="post">
   <div class="form-item">
    <label for="email">이메일</label>
    <input type="text" id="email" name="email">
    </div>
   
   <div class="form-item">
    <label for="password">비밀번호</label>
    <input type="password" id="password" name="password">
    </div>
    
    <hr>
    <button id="btnLogin" >로그인</button>
  </form>
</div>   

  
    <footer>
      <ul>
        <li>서울시 선릉역 We-Work</li>
        <li>02-0000-0000</li>
      </ul>
    </footer>
    
 </div>
</body>
</html>

