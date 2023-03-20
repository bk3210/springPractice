<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kosa.mycompany.score.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
  
</head>
<body>
<%
	ScoreDTO dto = (ScoreDTO)request.getAttribute("dto");
	String seq = request.getParameter("seq");
%>
<form name="myform" id="myform">
	<input type="hidden" id="seq" name="seq" value="<%=seq %>">


<!-- 메뉴 -->
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
      <img src="/myhome2/images/img_avatar1.png" alt="Avatar Logo" 
         style="width:40px;" class="rounded-pill"> 
    </a>
    
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>  
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Dropdown</a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Link</a></li>
            <li><a class="dropdown-item" href="#">Another link</a></li>
            <li><a class="dropdown-item" href="#">A third link</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>




<div class="container mt-3">
  <h3>Navbar With Dropdown</h3>
  <p>This example adds a dropdown menu in the navbar.</p>
  

   <table class="table">
   	<colgroup>
   		<col width="16%">
   		<col width="16%">
   		<col width="16%">
   		<col width="16%">
   		<col width="16%">
   		<col width="16%">
   	</colgroup>
    <tbody>
      <tr>
        <th>이름</td>
        <td>
        	<%=dto.getName() %> 
        </td>
      </tr>
      <tr>
        <th>국어</td>
        <td>
        	<%=dto.getKor() %> 
        </td>
      </tr>
      <tr>
        <th>수학</td>
        <td>
        	<%=dto.getMat() %> 
        </td>
      </tr>
      <tr>
        <th>영어</td>
        <td>
        	<%=dto.getEng() %> 
        </td>
      </tr>
      <tr>
        <th>합계</td>
        <td>
        	<%=dto.getEng() %> 
        </td>
      </tr>
      <tr>
        <th>평균</td>
        <td>
        	<%=dto.getName() %> 
        </td>
      </tr>
    </tbody>
  </table>
 </div>


 <div class="container" style="text-align:right">
	<button type="button" class="btn btn-primary">글쓰기</button>
 </div>

  
</form>
</body>
</html>