<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="myform" method="post" enctype="multipart/form-data"
	action="<%=request.getContextPath()%>/fileupload/save">
	<!-- servlet을 쓸 때는 action을 명시하지 않을 경우 자기가 자기를 호출하기 때문에 action을 추가 -->
 파일 첨부 : <input type="file" name="file1" id="file1">
 <input type="submit" value="파일전송"/>

</form>
</body>
</html>