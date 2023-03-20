<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.kosa.myapp3.board.*" %>
<%@ page import="com.kosa.myapp3.common.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KIM BOM</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  
</head>
<body>
<%
String pg=StringUtil.nullToValue(request.getParameter("pg"),"0");
%>
<form name="myform" id="myform">
	<input type="hidden" name="pg" id="pg" value="<%=pg %>">

<%@include file="../include/nav.jsp" %>

<%
List<BoardDTO> list = (List<BoardDTO>)request.getAttribute("boardList");
// DTO 객체에 담긴 정보를 가져옴
int totalCnt = (Integer)request.getAttribute("totalCnt");	// 총 페이지 갯수
%>
<div class="container mt-3">
  <h3>Navbar With Dropdown</h3>
  <p>This example adds a dropdown menu in the navbar.</p>
  
   <div class="input-group mt-3 mb-3">
	  <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown">
	    Dropdown button
	  </button>
	  <ul class="dropdown-menu">
	    <li><a class="dropdown-item" href="#">Link 1</a></li>
	    <li><a class="dropdown-item" href="#">Link 2</a></li>
	    <li><a class="dropdown-item" href="#">Link 3</a></li>
	  </ul>
	  <input type="text" class="form-control" placeholder="Username">
	  <div class="input-group-append">
	  	<button class="btn btn-primary" type="button" >GO</button>
	  </div>
	</div>

   <table class="table">
   <colgroup>
   	<col width="8%">
   	<col width="*">
   	<col width="14%">
   	<col width="14%">
   	<col width="12%">   	
   </colgroup>
    <thead class="table-dark">
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
      </tr>
    </thead>
    <tbody>
    <%for(int i=0; i<list.size(); i++){
    	BoardDTO dto = list.get(i);
    	String reply="";
    	for(int j=0; j<dto.getDepth(); j++)
    			reply = reply + "&nbsp;&nbsp;&nbsp;";		// depth값에 따라 답글이 들여쓰기하여 출력되도록
    		if(!reply.equals(""))
    			reply = reply + "Re)";
    	%>
      <tr>
        <td><%=totalCnt - dto.getNum()+1%></td>
        <td><%=reply%>
        <%if(dto.getDelyn2().equals("N")){ %>
  
        <a href="<%=request.getContextPath()%>/board/view?seq=<%=dto.getSeq()%>"><%=dto.getTitle() %></a></td>
        <%}else{ %>
        원글이 삭제되었습니다.
        <%} %>
        <td><%=dto.getUserid() %></td>
        <td><%=dto.getRegdate() %></td>
        <td><%=dto.getHit() %></td>
      </tr>
    <%} %>
    </tbody>
  </table>
 </div>
 <div class="container" style="text-align:right">
 <%=Pager.makeTag(request, totalCnt, 10) %>
</div>

 <div class="container" style="text-align:right">
	<button type="button" class="btn btn-primary" onclick="goWrite()">글쓰기</button>
 </div>  
</form>
</body>
</html>
<script>
<%-- function goPage(pg){
	document.getElementById("pg").value=pg;
	var frm=document.myform;
	frm.action="<%=request.getContextPath()%>/board/list";
	frm.submit();
}

function goPage(page){
	var frm = document.myform;
	frm.action="<%=request.getContextPath()%>/board/write";
	frm.method="POST";
	frm.submit();
}
 --%>

function goWrite(){
	var frm = document.myform;
	frm.action = "<%=request.getContextPath()%>/board/write";
	frm.method="post";
	frm.submit();
}

function goPage(page){
	$("#pg").val(page);
	$("#myform").prop("action", "<%=request.getContextPath()%>/board/list");
	$("#myform").submit();
}
</script>