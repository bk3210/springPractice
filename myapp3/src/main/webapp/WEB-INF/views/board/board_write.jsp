<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kosa.myapp3.common.*" %>
<%@ page import="com.kosa.myapp3.board.*" %>
<%@ page import="com.kosa.myapp3.member.*" %>
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
String mode = StringUtil.nullToValue(request.getParameter("mode"), "insert");
String seq = StringUtil.nullToValue(request.getParameter("seq"), "-1");

	// 글수정 : 수정할 글의 정보(수정글 DTO)
	// 답글 달기 : 원본글의 정보(원글 DTO)
	// 새 글 쓰기 : 아무것도 필요 없음(빈 DTO)
// 이렇게 세 DTO를 생성하고 어떤 화면에서든 DTO를 호출하게 만들어
// 화면에 따라 출력시킴(if문보다 간편)
BoardDTO dto = (BoardDTO)request.getAttribute("boardDTO");
/* HttpSession session = request.getSession(); */
%>
<form name="myform" id="myform">
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="seq" id="seq" value="<%=seq%>">
<!-- 	<input type="hidden" name="userid" id="userid" value="<%=%>"-->
	<!-- mode : 이 페이지에서 처리할 작업이 글쓰기, 글수정, 답글 달기 중 어느 모드인지 지정하는 변수
		 seq : 부모글의 seq(=group_id)
	value값은 만약 값이 넘어오지 않을 때 위 StringUtil 객체에 담긴 값을 받아온 값을 넣겠다는 뜻 -->
<%@include file="../include/nav.jsp" %>
<div class="container mt-3">
  <h3>새 글 쓰기</h3>
  
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
			    name="title" id="title" value="<%=dto.getTitle()%>">
			 </div>
        </td>
      </tr>
      <tr>
        <th>작성자</td>
        <td>
        	 <div class="input-group">
			    <input type="text" class="form-control" placeholder="이름을 입력하세요"
			    name="userid" id="userid" value="test3">
			 </div>
        </td>
      </tr>
      <tr>
        <th>내용</td>
        <td>
        	 <div class="input-group">
			    <textarea class="form-control" placeholder="내용 입력하세요"
			    name="contents" id="contents" rows="5"><%=dto.getContents()%></textarea>
			    <!--textarea는 value로 주지 않고 가운데에 값 입력-->
			 </div>
        </td>
      </tr>
      <tr>
        <th>첨부파일1</td>
        <td>
        <%if(!mode.equals("modify")){ %>
        	 <div class="input-group">
			    <input class="form-control" placeholder="파일을 첨부하세요"
			    type="file" name="file1" id="file1">
			 </div>
		<%}else{ %>
        	 <div class="input-group">
			    <input type="file" class="form-control" placeholder="파일을 첨부하세요" name="file1" id="file1" style="display:none"/>
			    <input type="checkbox" id="del1"	 onclick="goChange('1')" value="1"/>
			    <input type="text" name="old_name" id="old_name1" value="<%=dto.getFilename1() %>"	/>
			 </div>
		 <%} %>
        </td>
      </tr>
      <tr>
        <th>첨부파일2</td>
        <td>
        	 <%if(!mode.equals("modify")){ %>
        	 <div class="input-group">
			    <input class="form-control" placeholder="파일을 첨부하세요"
			    type="file" name="file2" id="file2">
			 </div>
		<%}else{ %>
        	 <div class="input-group">
			    <input type="file" class="form-control" placeholder="파일을 첨부하세요" name="file2" id="file2" style="display:none"/>
			    <input type="checkbox" id="del2" onclick="goChange('2')" value="2"/>
			    <input type="text" name="old_name" id="old_name2" value="<%=dto.getFilename2() %>"	/>
			 </div>
		 <%} %>
        </td>
      </tr>
      <tr>
        <th>첨부파일3</td>
        <td>
        	 <%if(!mode.equals("modify")){ %>
        	 <div class="input-group">
			    <input class="form-control" placeholder="파일을 첨부하세요"
			    type="file" name="file3" id="file3">
			 </div>
		<%}else{ %>
        	 <div class="input-group">
			    <input type="file" class="form-control" placeholder="파일을 첨부하세요" name="file3" id="file3" style="display:none"/>
			    <input type="checkbox" id="del3" onclick="goChange('3')" value="3"/>
			    <input type="text" name="old_name" id="old_name3" value="<%=dto.getFilename3() %>"	/>
			 </div>
		 <%} %>
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
	// goSave() : 메소드 호출결과를 전달
	$("#btnSave").click(goSave); // 메소드 주소만 전달
});

function goChange(id){
	//alert(id);
	if(document.getElementById("del"+id).checked){
		document.getElementById("file"+id).style.display="block";
	}else{
		document.getElementById("file"+id).style.display="none";
	}
}

function goSave(){
	// 자바스크립트 ajax로 파일을 전송할 때 FormData(form 객체) 메소드를 이용해 form에 있는
	// 데이터들을 직렬화한다
	// document.폼이름
	// jQuery의 경우 $("#폼 아이디")[0]	- 반드시 인덱스값을 명시해줘야 한다(form 객체가 배열이라)
	let frmData = new FormData(document.myform);
	console.log(frmData);
	for(key of frmData.keys()){
		console.log(key);	// 키 출력
		console.log(frmData.get(key));	// 값 출력
	}
		
	let file=frmData.get("file1");
	console.log(file.type);
	console.log(file.name);
	
	// 여기서 save할 것이 원글인지, 답글인지를 정할 수 있다
	if($("#mode").val()=="insert")
		url = "<%=request.getContextPath()%>/board/save";
	else if($("#mode").val()=="reply")
		url = "<%=request.getContextPath() %>/board/reply_save";
	else
		url = "<%=request.getContextPath() %>/board/modify_save";
	
		console.log($("#mode").val(), url);
		if($("#mode").val()=="modify"){
			for(i=1; i<=3; i++){
				// check되지 않은 경우만 추가
				if(!document.getElementById("del"+i).checked)
					frmData.append("del", "");
				else
					frmData.append("del", $("#del"+i).val());
				
			}
			
		}
	
	 $.ajax({
		url:url,
		data:frmData,
		processData:false,	// 여기서
		contentType:false,
		encType:"multipart/form-data",	// 여기까지 이 세개는 의례적으로 필요함
		timeout:600000,
		dataType:"JSON",
		type:"POST"	// 파일 전송방식은 반드시 POST
	})
	.done((res)=>{
		location.href="<%=request.getContextPath()%>/board/list";
		alert("등록 완료");
		console.log(res);
	})
	.fail((res, status, error)=>{
		console.log(status);
		console.log(error);
	})
		
}
	
	<%-- $("#btnSave").click(()=>{
		// 자바스크립트로 파일 전송시에는 FormData 객체를 만들어서 전송해야 한다
		// $("myform")[0] / document.myform 둘 중 하나로 접근해야 한다(FormData 객체는 배열로 생성되기 때문)
		let frmData = new FormData($("#myform")[0]);
		// 왜 id로 접근하느냐 : jQuery는 name으로 접근하는 게 너무 복잡하다(id가 편함)
		console.log(frmData);
		
		// image1의 내용을 가져와서 type Check를 해야함
		for(key of frmData.keys())
			console.log(key, frmData.get(key));
		$.ajax({
			url:"<%=request.getContextPath()%>/board/save",
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
	}); --%>

</script>