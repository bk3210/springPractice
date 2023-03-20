<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 정보</h1>
<h3>이름 : ${dto.user_name }</h3>
<h3>비밀번호 : ${dto.password }</h3>
<h3>아이디 : ${dto.user_id }</h3>
<h3>전화번호 : ${dto.phone }</h3>
<h3>주소 : ${dto.address }</h3>

</body>
</html>