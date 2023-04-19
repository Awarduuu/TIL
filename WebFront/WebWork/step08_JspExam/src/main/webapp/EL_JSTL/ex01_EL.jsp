<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

<h3>EL = 표현언어</h3>

\${5} = ${5} <br>
\${5*2} = ${5*2} <br>
\${5 gt 2} = ${5 gt 2} <br>
\${5 eq 5 || 3 lt 5} = ${5 eq 5 || 3 lt 5} <br>
\${5>3 ? "크다" : "작다"} = ${5>3 ? "크다" : "작다"} <br>
<hr>

<!-- http://localhost:8000/step08_JspExam/EL_JSTL/ex01_EL.jsp?id=jang&age=20 -->

아이디 : <%=request.getParameter("id") %> / ${param.id}<br>

<!-- 나이가 18보다 크면 성인입니다, 아니면 미성년자입니다. 출력 -->
${param.age gt 18 ? "성인입니다" : "미성년자입니다"}<br>

<!-- 만약 id가 있다면 id님, 없으면 guest님이라고 출력 -->
${param.id == null ? "guest님" : param.id += "님" }<br>
${param.id == null ? "guest님" : param.id.concat("님") }<br>
${empty param.id ? "guest님" : param.id += "님" }<br>
${not empty param.id ? param.id.concat("님") : "guest님" }<br>

<hr>
<%
	request.setAttribute("id", "8253jang");
	
	session.setAttribute("addr", "서울시 선릉역");
	session.setAttribute("message", "session영역에 저장된 메시지 입니다.");
	
	application.setAttribute("message", "application영역에 저장된 메시지 입니다.");
	application.setAttribute("hobbys", new String []{"등산", "수영", "골프"});
	
%>
<h3>Scope영역 (pageContext &lt; request &lt; session &lt; application) 정보 가져오기</h3>

아이디 : <%=request.getAttribute("id") %> / ${requestScope.id} / ${id}<br>
<hr>
주소 : <%=session.getAttribute("addr") %> / ${sessionScope.addr} / ${addr}<br>
메시지 : <%=session.getAttribute("message") %> / ${sessionScope.message} / ${message}<br>
<hr>
메시지(app) : <%=application.getAttribute("message") %> / ${applicationScope.message} / ${message}<br>
취미 : <%=application.getAttribute("hobbys") %> / ${applicationScope.hobbys} / ${hobbys}<br>

<hr>

<%
	String name="장희정";
%>

이름 : <%=name %> / ${name}

</body>

</html>

