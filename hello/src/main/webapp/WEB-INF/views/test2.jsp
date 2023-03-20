<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>test2.jsp</h1>
<h3><%=request.getAttribute("user_id") %></h3>
<h3>${password }</h3>
<h3>${user_id}</h3>
<!--둘 다 같은 결과이다(아래는 표현식이라고 부름) -->
<!-- 단, 표현식은 간결한 대신 배열에 접근할 수가 없음(for문과 함께 사용할 수 없음) -->
</body>
</html>