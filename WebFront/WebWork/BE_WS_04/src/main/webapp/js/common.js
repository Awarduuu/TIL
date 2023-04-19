/**
 * 
 */

 $(function(){
      $("#Logout").click(function(e){
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
		    	url : "logout", // 서버주소(요청주소)
		    	type: "post" , //요청방식 (get | post | put | delete )
		    	dataType : "json",  //서버가 응답할때 전달하는 데이터 타입 (text | html | xml | json)
		    	//data : , //서버에게 전달하는 parameter정보 
		    	success : function(data , status ){//응답결과가 성공했을때 함수
		    	     if(data.result=="success"){
		    	    	 alert("로그인되었습니다.")
		    	     }else{
		    	    	 alert("로그인실패하였습니다.")
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