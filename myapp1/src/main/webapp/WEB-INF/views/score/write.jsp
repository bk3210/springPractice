<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="myform" method="post" action="/myapp1/score/save">
	번호 : <input type="text" name="seq"><br/>
	이름 : <input type="text" name="name"><br/>
	국어 : <input type="text" name="kor"><br/>
	영어 : <input type="text" name="eng"><br/>
	수학 : <input type="text" name="mat"><br/>
	<button>등록</button>
</form>
</body>
</html>