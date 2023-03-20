<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.kosa.myapp1.score.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List<ScoreDTO> list = (List<ScoreDTO>)request.getAttribute("list");
	for(int i=0; i<list.size(); i++){
		ScoreDTO dto = list.get(i);
%>
	<h1>이름 : <%=dto.getName() %></h1>&nbsp;&nbsp;
	<h3>국어 : <%=dto.getKor() %></h3>&nbsp;&nbsp;
	<h3>수학 : <%=dto.getMat() %></h3>&nbsp;&nbsp;
	<h3>영어 : <%=dto.getEng() %></h3>&nbsp;&nbsp;<br/>
<%} %>
</body>
</html>