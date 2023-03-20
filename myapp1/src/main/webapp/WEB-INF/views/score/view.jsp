<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kosa.myapp1.score.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
ScoreDTO dto = (ScoreDTO)request.getAttribute("dto");
%>
<%=dto.getSeq() %><br/>
<%=dto.getName() %><br/>
<%=dto.getKor() %><br/>
<%=dto.getMat() %><br/>
<%=dto.getEng() %><br/>

</body>
</html>