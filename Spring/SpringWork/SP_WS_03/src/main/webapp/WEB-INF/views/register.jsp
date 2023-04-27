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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer.css">
  <style>

    #register {
      margin-top: 5px;
      padding: 20px 0px;
    }

    #register h1 {
      padding: 5px;
      text-align: center;
    }

    #register form{
      display: block;
      width: 100%;
      height: 300px;
      border: 1px solid lightgrey;
      padding: 40px;
    }

    #register .form-item{
      margin-bottom: 10px;
    }

    #register .form-item label{
      display: inline-block;
      width: 150px;
      font-size: 18px;
    }

    #register .form-item input{
      display: inline-block;
      width: 250px;
      font-size: 18px;
    }

    #register button{
      margin-top: 10px;
      padding: 5px;
      float: right;
      width: 100px;
      font-size: 18px;
    }    
 
  </style>
  <title>IT's KB - register</title>
</head>
<body>
  <div id="container">
  
    <!-- navBar 로 대체 -->
  	<jsp:include page="/WEB-INF/views/navBar.jsp" flush="true"/>
  	
    <div id="banner">지금 당신의 행복! IT's KB Life!</div>
   <div id="register">
	  <h1>Register</h1>
	  <form method="post" id="regForm">
	  <div class="form-item">
	    <label for="name">이름</label>
	    <input type="text" id="name" name="name">
	 </div>
	    
	   <div class="form-item">
	    <label for="email">이메일</label>
	    <input type="email" id="email" name="email">
	  </div>
	  
	   <div class="form-item">
	    <label for="phone">연락처</label>
	    <input type="text" id="phone" name="phone">
	   </div>
	   
	    <div class="form-item">
		    <label for="password">비밀번호</label>
		    <input type="password" id="password" name="password">
	    </div>
	    
	   <div class="form-item">
		    <label for="password2">비밀번호 확인</label>
		    <input type="password" id="password2" name="password2">
	    </div>
	    
	    <hr>
	    <button id="btnRegister" type="button">회원 가입</button>
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
  <script src="${pageContext.request.contextPath}/js/common.js"></script>
  <script type="text/javascript">
    $(function(){
    	getBanner('${pageContext.request.contextPath}');
    	
    	//가입 버튼 클릭
    	$("#btnRegister").click(function(){
    	
    	let state=true; // forEach를 빠져나가기위한 상태변수 
    	$("input").each(function( index,item){
    		if(state){
    		  if( validateCheck(item)){ 
    			  state=false;
    		  }
    		}/* else{
    			return false;
    		} */
    	});
    	
    	if(state){
    		let email = $("#email");
        	
    	   if(email.val().indexOf("@")==-1){
    		alert("이메일형식이 아닙니다.")
    		email.val("");
    		email.focus();
    		return;
    	   }
    	
    	   
    	   let password = $("#password");
           let password2 = $("#password2");
           
    	   if(password.val() != password2.val()){
    		 alert("비밀번호가 일치하지 않습니다.");
    		
    		$("[type='password']").each(function(index,item){
    			  item.value=""; 
    		});
    		password.focus(); 
    		return;
    	  }
    	
//////////////////////////////////////////////////////
       	$.ajax({
       		url:"${pageContext.request.contextPath}/user?job=register",
       		type:"post",
       		data: $("#regForm").serialize() ,
       		dataType:"json",
       		success: function(data, status, xhr){
       			console.log(data);
       			if(data.result=="success"){
           				 alert("회원가입 되었습니다. 로그인 페이지로 이동합니다.")
           			     window.location.href="${pageContext.request.contextPath}/login.jsp";          		
       			}else{
           			alert("가입 실패2")
       			}
       		},
       		error : function(jqXHR, textStatus, errorThrown){
       			alert("문제 발생 : " + jqXHR.status)
       		}
       	
       		
       	});
       	
    	}//if문끝
    	
     });//clickEnd
    	
    	//유효성 체크 (input요소를 객체로 전달받아 값 입력 체크 없으면 커서 놓기 )
    	function validateCheck(obj){
    		if(obj.value===""){
    			alert("값을 입력해주세요.");
    			obj.focus();
    			return true;
    		}else{
                return false;
    		}
    	}
    	
    	
    	
    	
    })//readyEnd
  
  </script>
 
</body>
</html>