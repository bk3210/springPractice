<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.kosa.mycompany.member.*" %>
<%@ page import="com.kosa.mycompany.common.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  
</head>
<body>
<%
String pg=request.getParameter("pg");
if(pg==null || pg.equals("")){
	pg="0";	// pg가 null값이 들어올 때 예외처리 해줘야 함
}
%>
<form name="myform" id="myform">
	<input type="hidden" name="pg" id="pg" value="<%=pg%>">
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

<%
int totalCnt=(Integer)request.getAttribute("totalCnt");
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

   <table class="table" id="mytable">
    <colgroup>
    	<col width="8%">
    	<col width="12%">
    	<col width="*">
    	<col width="18%">
    	<col width="14%">
    </colgroup>
    <thead class="table-dark">
      <tr>
        <th>회원번호</th>
        <th>아이디</th>
        <th>이름</th>
        <th>이메일</th>
        <th>전화번호</th>
      </tr>
    </thead>
    <tbody>
    </tbody>
  </table>
 </div>
 <div class="container" style="text-align:right">
 <%=Pager.makeTag(request, totalCnt, 10) %>
</div>

 <div class="container" style="text-align:right">
	<button type="button" class="btn btn-primary">글쓰기</button>
 </div>  
</form>
</body>
</html>

<script>
	$(()=>{
		load_data();	// ajax를 이용해 불러온 데이터를 jsp에 추가하는 메소드
	})
	
	function goPage(pg){
		$("#pg").val(pg);// 페이징 1. 바뀐 페이지의 값을 읽어와서
		$("#myform").prop("action", "<%=request.getContextPath()%>/member/member_list");
		$("#myform").submit();
	}
	
	function load_data(){
		let pg=$("#pg").val();		
		$.ajax({
			url:"<%=request.getContextPath()%>/member/list_data",
			data:{pg:pg},	// 2. 페이지값을 전달하기
			dataType:"JSON",
			method:"POST"
		})
		.done((res)=>{
			// console.log(res);
			res.data.forEach((item)=>{	// 데이터 추가(배열형태라 forEach 사용)
				tr="<tr><td>"+item.m_id+"</td>";
				tr+="<td>"+item.m_userid+"</td>";
				tr+="<td>"+item.m_name+"</td>";
				tr+="<td>"+item.m_email+"</td>";
				tr+="<td>"+item.m_phone+"</td></tr>";
				console.log(tr);
				$("#mytable > tbody:last").append(tr);	
			})
		})
		.fail((res, status, error)=>{
			console.log(status);
			console.log(error);
		})
	}

</script>