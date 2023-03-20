<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<form name="myform" id="myform">

<!-- 메뉴 -->
<%@include file="../include/nav.jsp" %>

<div class="container mt-3">
  <h3>Navbar With Dropdown</h3>
  <p>This example adds a dropdown menu in the navbar.</p>
  

   <table class="table">
   	<colgroup>
   		<col width="30%">
   		<col width="*">
   	</colgroup>
    <tbody>
      <tr>
        <th>아이디</td>
        <td>
        	 <div class="input-group">
			    <input type="text" class="form-control" 
			    placeholder="아이디를 입력하세요"
			    name="user_id" id="user_id">			 
			 </div>
        </td>
      </tr>
      <tr>
        <th>패스워드</td>
        <td>
        	 <div class="input-group">
			    <input type="password" class="form-control" 
			    placeholder="패스워드를 입력하세요"
			    name="password" id="password">
			 </div>
        </td>
      </tr>
    </tbody>
  </table>
 </div>


 <div class="container" style="text-align:right">
	<button type="button" class="btn btn-primary" id="btnLogin">로그인</button>
 </div>
  
</form>
</body>
</html>

<script>
	$(()=>{
		$("#btnLogin").click(()=>{
			// 파일 전송이 아닐 때는 직렬화로 전달한다
			let data = $("#myform").serialize();		
			console.log(data);
			$.ajax({
				url:"<%=request.getContextPath()%>/member/go_login",
				data:data,
				type:"POST",
				dataType:"JSON"
			})
			.done((res)=>{
				alert(res.msg);
				if(res.result=="success"){
					location.href="<%=request.getContextPath()%>/";
				}
			})
			.fail((res, status, error)=>{
				console.log(error);		
			})
		});
	})

	/*
		onclick
		addEventListener : id를 이용해서 이벤트핸들러 추가
		jQuery click함수 : id를 이용해서 이벤트핸들러 추가
		최근에는 onclick을 점점 지양해가는 추세
	*/


</script>
