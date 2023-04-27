    let bannerIndex=0;
    let bannerList=[];
   
    function getBanner(contextPath){
		console.log("contextPath = " + contextPath);
    	let banner = $("#banner");
    	
    	//서버와 통신
    	$.ajax({
    		url:contextPath+"/banners",
    		type:"get",
    		dataType:"json",
    		success: function(result, status, xhr){
    			console.log("result = "+result)
    			console.log("status = "+status)
    			console.log("xhr = "+xhr)
    			
    			bannerList = result;
    			console.log("bannerList = "+bannerList)
    			
    			let bannerText = bannerList[bannerIndex++];
    			banner.text(bannerText);
    			
    			setInterval(function(){
    				let bannerText = bannerList[bannerIndex++];
        			banner.text(bannerText);
        			
        			if(bannerIndex==bannerList.length) bannerIndex=0;
        			
        			
    			}, 3000);
    			
    		},
    		error : function(jqXHR, textStatus, errorThrown){
    			alert("문제 발생 : " + jqXHR.status)
    		}
    		
    	});//ajaxEnd
    	
     }//getBannerEnd
   
    

////////////////////////////////////////////////////////////////////////
 function logout(contextPath){
   $.ajax({
    		url:contextPath+"/logout",
    		type:"get",
    		dataType:"json",
    		success: function(data, status, xhr){
    			if(data.result == "success"){
			        window.location.href =  contextPath+"/index.jsp"; // 비동기 요청 X
		       }else{
			       alert("로그아웃 과정에 문제가 생겼습니다. 다시 로그아웃 해 주세요.");
		       }
    		},
    		error : function(jqXHR, textStatus, errorThrown){
    			alert("문제 발생 : " + jqXHR.status)
    		}
    		
    	});//ajaxEnd
   } //logoutEnd	

/*async function logout(contextPath){

	let url = contextPath + '/logout'
	try{
		let response = await fetch(url);
		let obj = await response.json();
		
		if(obj.result == "success"){
			window.location.href = contextPath + "/index.jsp"; // 비동기 요청 X
		}else{
			alert("로그아웃 과정에 문제가 생겼습니다. 다시 로그아웃 해 주세요.");
		}
	}catch( error ){
		console.error( error );
		alert("로그아웃 과정에 문제가 생겼습니다. 다시 로그아웃 해 주세요.");
	}	
}*/