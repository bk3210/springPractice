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
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
      <img src="/mycompany/resources/images/logo.png" alt="logo" 
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
   		<col width="30%">
   		<col width="*">
   	</colgroup>
    <tbody>
      <tr>
        <th>제목</td>
        <td>
        	 <div class="input-group">
			    <input type="text" class="form-control" placeholder="제목을 입력하세요"
			    name="title" id="title">
			 </div>
        </td>
      </tr>
       <tr>
        <th>내용</td>
        <td>
        	 <div class="input-group">
			    <textarea class="form-control" placeholder="내용을 입력하세요"
			    name="contents" id="contents" rows="5"></textarea>
			 </div>
        </td>
      </tr>
      <tr>
        <th>이미지 첨부</td>
        <td>
        	 <div class="input-group">
			    <input class="form-control" placeholder="이미지 파일을 첨부하세요"
			    type="file" name="file1" id="file1"/>
			 </div>
        </td>
      </tr>

    </tbody>
  </table>
 </div>

 <div class="container" style="text-align:right">
	<button type="button" class="btn btn-primary" id="btnSave">글쓰기</button>
 </div>

</form>
</body>
</html>
<script>
$(()=>{
	$("#btnSave").click(()=>{
		// 자바스크립트로 파일 전송시에는 FormData 객체를 만들어서 전송해야 한다
		// $("myform")[0] / document.myform 둘 중 하나로 접근해야 한다(FormData 객체는 배열로 생성되기 때문)
		let frmData = new FormData($("#myform")[0]);
		// 왜 id로 접근하느냐 : jQuery는 name으로 접근하는 게 너무 복잡하다(id가 편함)
		console.log(frmData);
		
		// image1의 내용을 가져와서 type Check를 해야함
		for(key of frmData.keys())
			console.log(key, frmData.get(key));
		$.ajax({
			url:"<%=request.getContextPath()%>/home/save",
			data:frmData,
			processData:false,	// fileupload시 꼭 필요
			contentType:false,	//	fileupload시 꼭 필요
			enctype:"multipart/form-data",	// fileupload시 꼭 필요
			timeout:600000,	// 전송시간 제한
			dataType:"JSON",
			type:"POST"	// file 전송시 반드시 필요, 꼭 POST로 보내야 함
		})
		.done((res)=>{
			console.log(res);
		})
		.fail((res, status, error)=>{
			console.log(status);
		})
	});
})

</script>