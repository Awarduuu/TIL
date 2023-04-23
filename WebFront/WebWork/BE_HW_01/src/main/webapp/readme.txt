DB
	기존 users 데이터 truncate
	password varchar2(20) not null 추가
	login test user 1건 등록 
	insert into users values( 1, '홍길동', 'hong@gildong.com', '010-1111-1111', 'N', '1234');
	commit;
	
FE
	login.html -> login.jsp
	register.html -> register.jsp
	personal.html -> personal.jsp
	
	navbar.jsp 추가 하고 각 jsp 에서 include
		logo 이미지 - index.jsp 연결
	
	jQuery 기준 WS_05 에서 진행한 것처럼  js 폴더에 banner.js 와 동일한 common.js 추가 단, jQuery 가 아닌   vanilla	JavaScript 로
	login.html 과 register.html 에도  banner 적용
	logo.png -> img 폴더 만들고 그 안에
	
	
	login.jsp
	validation 추가
	BE 연동 코드 작성
	login 성공하면 index.jsp 로 이동 
	navBar.jsp 에서 session 에 userDto 가 있으면 로그인 대신 로그아웃으로 link 변경
	로그아웃 link 클릭하면 logout() 호출 BE 연동 처리 다시 index.jsp 로
	
            ** context path 이슈 context path 사용하지 않으면 login() 에 context path 전달 X	

BE
	ojdbc6.jar, gson.jar 를 tomcat 설치폴더 /lib 폴더에 넣는다.
	LoginServlet, LoginService, LoginDao 관련 작성
	LoginServlet - login:post, logout:get