/**
 * 
 */

let bannerList = [];
let bannerIndex = 0;

function getBanner(contextPath){
	let bannerEle =  $("#banner");
	 //ajax 요청한다.//////////////////////////////////////////////////////////
	 $.ajax({
	    	url : contextPath + "/banners", // 서버주소(요청주소)
	    	type: "get" , //요청방식 (get | post | put | delete )
	    	dataType : "json",  //서버가 응답할때 전달하는 데이터 타입 (text | html | xml | json)
	    	//data : , //서버에게 전달하는 parameter정보 
	    	success : function(result){//응답결과가 성공했을때 함수
	    	
			 	
			 	bannerList = result;
	        	// 주기적으로 banner 변경
	         	setInterval(function(){
	         		bannerEle.html (bannerList[bannerIndex++]);
	         		if(bannerIndex==bannerList.length ){
	         			bannerIndex=0;
	         		}
	         	} , 2000);
	
	    	}, 
	    	error : function(err, status){//응답결과가 실패했을때 함수 
	    		// 에러발생....
	    		alert(err +"발생했습니다. status = " + status);
	    	} 
	    });
}


function logout(contextPath){
	location.href=contextPath + "/logout";
}
