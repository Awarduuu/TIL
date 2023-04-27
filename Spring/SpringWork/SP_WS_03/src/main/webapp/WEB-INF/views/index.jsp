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

    #main {
      margin-top: 5px;
      display: flex;
      justify-content: space-between;
    }

    #main .main-item {
      display: inline-block;
      width: 33%;
    }

    #main .main-item img{
      widt.h: 100%;
    } 
    
    #main .main-item h2{
      margin-top: 5px;
    } 

    #main .main-item p{
      margin-top: 5px;
    }

    #main .main-item button{
      margin-top: 5px;
      padding: 5px;
      float: right;
      width: 80px;
      font-size: 18px;
    }


  </style>
  
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
   <script src="${pageContext.request.contextPath}/js/common.js"></script>
  <script>
    // #1. logo image url 변경
    // #2. common.js 이용
    $(function(){
    	 getBanner('${pageContext.request.contextPath}');
    	 
    	 
    	 //버튼 클릭했을대
   	   $(".main-item-btn").click(function(){
   		 let idValue =  $(this).closest(".main-item").attr("data-main-item-id");
   		 console.log(idValue)
   	   });
    	 
    })//
    

  </script>
   
  <title>IT's KB</title>
</head>
<body>
  <div id="container">
  
    <!-- navBar 로 대체 -->
  	<jsp:include page="/WEB-INF/views/navBar.jsp" flush="true"/>
  	
  	
    <div id="banner"></div>
    <div id="main">
      <div class="main-item" data-main-item-id="10">
        <img src="https://picsum.photos/200" alt="">
        <h2>main-item 1</h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
        <button class="main-item-btn">button 1</button>
      </div>
      <div class="main-item" data-main-item-id="20">
        <img src="https://picsum.photos/200" alt="">
        <h2>main-item 2</h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
        <button class="main-item-btn">button 2</button>
      </div>
      <div class="main-item" data-main-item-id="30">
        <img src="https://picsum.photos/200" alt="">
        <h2>main-item 3</h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
        <button class="main-item-btn">button 3</button>
      </div>
    </div>
    
    <div id="footer">
      <ul>
        <li class="address">12345 address 1 address 2 address 3</li>
        <li class="phone">02-0000-0000</li>
      </ul>
    </div>
  </div>
  
</body>
</html>