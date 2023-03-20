<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.kosa.mycompany.gallery.*"%>
<%@ page import="com.kosa.mycompany.common.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

</head>
<body>
<%
String searchKey = request.getParameter("searchKey");
String searchKeyword = request.getParameter("searchKeyword");
%>
<form name = "myform" id="myform">
	<input type="hidden" name="pg" id="pg" value="0">
	
	<!-- 메뉴 -->
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img
				src="/mycompany/resources/images/logo.png" alt="logo"
				style="width: 40px;" class="rounded-pill">
			</a>

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="collapsibleNavbar">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown">Dropdown</a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">Link</a></li>
							<li><a class="dropdown-item" href="#">Another link</a></li>
							<li><a class="dropdown-item" href="#">A third link</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>


	<div class="container mt-3">
		<h3>Navbar With Dropdown</h3>
		<p>This example adds a dropdown menu in the navbar.</p>

		<div class="input-group mt-3 mb-3">
			<button type="button" id="select" class="btn btn-primary dropdown-toggle"
				data-bs-toggle="dropdown">선택하세요</button>
			<ul class="dropdown-menu">
				<li><a class="dropdown-item" href="#" onclick="goSearchKey('0')">선택하세요</a></li>
				<li><a class="dropdown-item" href="#" onclick="goSearchKey('1')">제목</a></li>
				<li><a class="dropdown-item" href="#" onclick="goSearchKey('2')">내용</a></li>
				<li><a class="dropdown-item" href="#" onclick="goSearchKey('3')">제목+내용</a></li>
			</ul>
			<!-- ul태그에는 값이 저장되지 않으므로 서버에 보내기 위해 input 태그에 담는다
			searchKey, searchKeyword 매개변수는 BaseDTO에 있음 -->
			<input type="hidden" name="searchKey" id="searchKey" value="<%=searchKey%>"/>
			<input type="text" class="form-control" name="searchKeyword" id="searchKeyword" value="<%=searchKeyword %>" placeholder="searchKeyword">
				<div class="input-group-append">
					<button class="btn btn-primary" type="button" onclick="goSearch()">GO</button>
			</div>
		</div>
	
	
		<!-- 이미지 뜨는 곳 -->
		<div id="contentsdiv"></div>
	</div>
	
	
	<div class="container" style="text-align: right">
		<ul class="pagination justify-content-center">
			<li class="page-item"><a class="page-link" href="#">first</a></li>
			<li class="page-item"><a class="page-link" href="#">Previous</a></li>
			<li class="page-item"><a class="page-link" href="#">1</a></li>
			<li class="page-item active"><a class="page-link" href="#">2</a></li>
			<li class="page-item"><a class="page-link" href="#">3</a></li>
			<li class="page-item"><a class="page-link" href="#">4</a></li>
			<li class="page-item"><a class="page-link" href="#">5</a></li>
			<li class="page-item"><a class="page-link" href="#">6</a></li>
			<li class="page-item"><a class="page-link" href="#">7</a></li>
			<li class="page-item"><a class="page-link" href="#">8</a></li>
			<li class="page-item"><a class="page-link" href="#">9</a></li>
			<li class="page-item"><a class="page-link" href="#">10</a></li>
			<li class="page-item"><a class="page-link" href="#">Next</a></li>
			<li class="page-item"><a class="page-link" href="#">last</a></li>
		</ul>
	</div>


	<div class="container" style="text-align: right">
		<button type="button" class="btn btn-primary">글쓰기</button>
	</div>


	</form>
</body>
</html>

<script>

$(()=>{
	load_data();
})

<%-- function goPage(pg){
	$("#pg").val(pg);
	$("#myform").prop("action", "<%=request.getContextPath()%>/gallery/gallery_list");
	$("#myform").submit();
} --%>

function load_data(){
	let temp = "";
	$.ajax({
		url:"<%=request.getContextPath()%>/gallery/list_data",
		data:{
			pg:0,
			searchKey:$("#searchKey").val(),
			searchKeyword:$("#searchKeyword").val()
		},
		dataType:"JSON"
	})
	// .done한 결과값을 res(변수명은 아무거나)로 받겠다고 약속함()
	.done((res)=>{
		console.log(res);
		data=res.data
			for (i=0; i<data.length; i++){
				if(i%4==0)
					temp += '<div class="row">               ';   
					temp += '	<div class="col-sm-3">       ';
					temp += '	  <div class="thumbnail">    ';
					temp += '		    <a href="<%=request.getContextPath()%>/upload/'+ data[i].image1 + '"> ';
					temp += '		      <img src="<%=request.getContextPath()%>/upload/'+ data[i].image1 + '" alt="Lights" style="width:100%"> ';
					temp += '		      <div class="caption"> ';
					temp += '		        <p>' +  data[i].title +'</p> ';
					temp += '		      </div> ';
					temp += '		    </a> ';
					temp += '		  </div> ';
					temp += '		</div> ';
				if(i%4==3 || i==data.length-1)
					temp += '</div>';
			}
		console.log(temp);
		$("#contentsdiv").html(temp);	// 출력
	})
	.fail((res, status, error)=>{
		console.log(status);
		console.log(error);
	});
}

function goSearchKey(key){
	var select=["선택하세요", "제목", "내용", "제목+내용"];
	$("#select").html(select[key]);
	$("#searchKey").val(key);
}

function goSearch(){
	$("#myform").prop("action", "<%=request.getContextPath()%>/gallery/list");
	$("#myform").submit();
}

/* 
 *		 ` : 백틱(자바스크립트에서 소스 코드를 하나로 감싸는 역할)
 * 
 	let temp = "";
		for(i=0; i<12; i++){
			if(i%4==0)
				temp += '<div class="row">               ';
				temp += '<div class="col-sm-3">';
				temp +=	'<div class="thumbnail">';
				temp +=	'	<a href="/mycompany/upload/a.jpg">';
				temp += '<img src="/mycompany/upload/a.jpg" alt="chicago" style="width: 100%">';
				temp += '			<div class="caption">';
				temp += '				<p>Lorem ipsum...</p>';
				temp += '			</div>';
				temp += '		</a>';
				temp += '	</div>';
				temp += '</div>';
			if(i%4==3 || i==11)
				temp += '</div>';
		`}
console.log(temp);
$("#contentsdiv").html(temp);
*/
</script>