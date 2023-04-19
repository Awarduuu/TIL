<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<title>IT's KB - register</title>
  <link rel="stylesheet" href="css/common.css">
  <link rel="stylesheet" href="css/navbar.css">
  <link rel="stylesheet" href="css/footer.css">
  
  <style type="text/css">
     #register{
        padding: 20px 0;
     }
     #register h1{
      padding: 5px; 
      text-align: center;
     }
     
     #register form{
        /*background-color:pink;*/
       width: 100%;
       height: 300px;
       border: 1px solid lightgray;
       padding: 40px;
     }
     
     #register .form-item{
        margin-bottom: 10px;
     }
     
     #register .form-item label{
     display:inline-block;
       width: 150px;
       font-size: 18px;
     }
     
     #register .form-item input{
     display:inline-block;
       width: 250px;
       font-size: 18px;
     }
     
     #register button{
       float:right;
       padding: 5px;
       width: 100px;
       font-size: 18px;
       margin-top: 10px;
     }
  </style>
   <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  
  <script type="text/javascript">
  
     $(document).ready(function(){
    	 $("#btnRegister").on("click", function(){
    	    	let state=true; 
    	    	$("input").each(function( index , item){
    	    		if(state){
    	    		  if( validateCheck( item ) ){ //유효성체크에서 실패
    	    			  state=false; 
    	    		      console.log(1)
    	    		      return false; //each 빠져나간다.
    	    		  }
    	    		}/*else{
    	    			console.log(2);
    	    		}*/
    	    	});//반복문끝
    	    	
    	    
    	    	
    	    	if(state){ //유효성체크가 완료가 되었다면
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
    	    	
    	    	   $("#regForm").submit();//전송(form의 action으로 설정한 곳으로 이동)
    	    	}//if문끝
    	    	
    	 });//click end
    	 
    	 
    	//유효성 체크 (input요소를 객체로 전달받아 값 입력 체크 없으면 커서 놓기 )
     	function validateCheck(obj){ //obj = item전달
     		if(obj.value===""){//obj가 이름, 이메일, 연락, 비번....
     			alert("값을 입력해주세요.");
     			obj.focus();
     			return true;
     		}else{
                 return false;
     		}
     	}//유효성체크 끝
     	
    	 
     });//readyEnd
  
  
  
  </script>
  
</head>
<body>
<div id="container">


  <%@ include file="navBar.jsp" %>
    
    <div id="banner">지금 당신의 행복! IT's KB Life!</div> 
    
  <div id="register">
	  <h1>Register</h1>
	  <form action="index.html" method="post" id="regForm">
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
 
   <footer>
      <ul>
        <li>서울시 선릉역 We-Work</li>
        <li>02-0000-0000</li>
      </ul>
    </footer>
    </div>
 </body>
</html>

