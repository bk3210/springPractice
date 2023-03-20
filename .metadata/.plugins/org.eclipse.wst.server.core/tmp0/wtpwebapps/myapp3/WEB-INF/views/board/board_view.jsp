<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.kosa.myapp3.board.*"%>
<%@ page import="com.kosa.myapp3.comment.*"%>
<%@ page import= "com.kosa.myapp3.common.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
   
</head>

<body>
	<%@include file="../include/nav.jsp"%>
	<%
	String pg=StringUtil.nullToValue(request.getParameter("pg"), "0");
	String seq=StringUtil.nullToValue(request.getParameter("seq"), "");
	BoardDTO dto = (BoardDTO) request.getAttribute("dto");
	%>
	<form name="myform" id="myform">
		<input type="hidden" name="board_seq" id="board_seq" value="<%=seq %>">
		<input type="hidden" name="pg" id="pg" value="<%=pg%>">
		<input type="hidden" name="seq" id="seq" value="<%=seq%>">
		<input type="hidden" name="userid" id="userid" value="test1">
		<input type="hidden" name="mode" id="mode">
		<input type="hidden" name="group_id" id="group_id" value="<%=dto.getGroup_id() %>">
		<input type="hidden" name="depth" id="depth" value="<%=dto.getDepth()%>">
		<input type="hidden" name="g_level" id="g_level" value="<%=dto.getG_level()%>">
		<!-- 여기서 mode값을 write로 넘김 -->
		
		<div class="container mt-3">
			<h3></h3>
			<p></p>
			<table class="table">
				<colgroup>
					<col width="16.6%">
					<col width="16.6%">
					<col width="16.6%">
					<col width="16.6%">
					<col width="16.6%">
					<col width="16.6%">
				</colgroup>
				<tbody>
					<tr>
						<th>제목
						</td>
						<td colspan="5"><%=dto.getTitle()%></td>
					</tr>
					<tr>
						<th>작성자
						</td>
						<td><%=dto.getUserid()%></td>
						<th>작성일
						</td>
						<td><%=dto.getRegdate()%></td>
						<th>조회수
						</td>
						<td><%=dto.getHit()%></td>
					</tr>
					<tr>
						<th>파일1</th>
						<td><a href="<%=request.getContextPath() %>/download?path=board&filename=<%=dto.getFilename1() %>" class="btn"><%=dto.getFilename1()%></a></td>
						<th>파일2</th>
						<td><a href="#" class="btn"><%=dto.getFilename2()%></a></td>
						<th>파일3</th>
						<td><a href="#" class="btn"><%=dto.getFilename3()%></a></td>
					</tr>
					<tr>
						<th colspan="6">내용</th>
						</tr>
					<tr>
						<td colspan="6" style="word-break: break-all"><%=dto.getContents().replaceAll("\n", "<br/>")%></td>
					</tr>
				</tbody>
				<tbody>
					<tr>
						<td colspan="6"><img style="width:1024px" src=<%=request.getContextPath()%>/upload/board/<%=dto.getFilename1()%>></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="container" style="text-align:right">
	<button type="button" class="btn btn-primary" id="btnReply">답글</button>&nbsp;&nbsp;
	<button type="button" class="btn btn-primary" id="btnModify">글수정</button>&nbsp;&nbsp;
	<button type="button" class="btn btn-primary" id="btnDelete">글삭제</button>&nbsp;&nbsp;
	<button type="button" class="btn btn-primary" id="btnList">글목록</button>
 </div>
 
 <!-- 댓글창 -->
 <div class="container mt-3">
 <!-- 댓글 입력창 -->
 <table class="table">
 	<tbody>
 		<tr>
 			<td>
 				<div class="input-group">
 				<!-- 직렬화할 때는 id값이 아니라 name값으로 접근한다 -> name을 주자! -->
 					<textarea type="text" id="comments" class="form-control" rows="4" name="comments"></textarea>
 				</div>
	 		</td>
 			<td stype="width:20%">
 			<button class="btn btn-primary" type="button" id="btnCmt">댓글 작성</button>
 			</td>
 		</tr>
 	</tbody>
 </table>
 <br/>
 	
 	<!-- 댓글 리스트 -->
 <table class="table" id="cmtList"> 
 	<tbody>
 		<tr>
 			<td style="width:100%">
 			작성자 : 
 			내용 : 
 			</td>
 		</tr>
 	</tbody>
 
 </table>
 </div>
   
	</form>
</body>
</html>
<script>
$(()=>{
	load_comment();
	
	$("#btnReply").click(()=>{
		$("#mode").val("reply");
		$("#myform").prop("action", "<%=request.getContextPath()%>/board/reply");
		$("#myform").submit();
	});
	
	$("#btnModify").click(()=>{
		$("#mode").val("modify");
		$("#myform").prop("action", "<%=request.getContextPath()%>/board/modify");
		$("#myform").submit();	
	});

	$("#btnList").click(()=>{
		$("#myform").prop("action", "<%=request.getContextPath()%>/board/list");
		$("#myform").submit();
	});

	$("#btnDelete").click(()=>{
		let param = $("#myform").serialize();
		// 직렬화 : url의 seq=4&group_id=3, 이런 식의 파라미터를 하나로 묶어주는 것
		//			multipart(파일 전송 방식)가 아닐 때
		// FormData : multipart일 때 사용
		$.ajax({
			url:"<%=request.getContextPath()%>/board/delete",
			data:param,
			dataType:"JSON"	
		})
		.done((res)=>{
			if(res.result=="success"){
				alert("글이 삭제되었습니다.");
				location.href="<%=request.getContextPath()%>/board/list";
			}else{
				alert("글 삭제에 실패하였습니다.");
			}
		})
		.fail((res, status, error)=>{
			console.log(status);
			console.log(error);
		});
	})
	
	// 자바스크립트를 라이브러리화한 게 jQuery
	// serialize는 jQuery가 만든 것
	// 직렬화 : board_seq=12&comments=~~~~&userid=test 형식으로 파라미터를 하나로 가공해 주는 것
	$("#btnCmt").click(()=>{
		let param = $("#myform").serialize();
		console.log(param);
		
		//data:{userid:"nananananana",board_seq:$("#board_seq").val(),comments:$("#comments").val()},
		$.ajax({
			url:"<%=request.getContextPath()%>/comment/insert",
			data:param,
			dataType:"JSON"
		})
		.done((res)=>{
			if(res.result=="success"){
				location.href="<%=request.getContextPath()%>/board/view?seq=<%=seq%>";
			}else{
				alert("실패@!");	
			}
		})
		.fail((res, status, error)=>{
			console.log(status);
			console.log(error);
		});
	})
	
})

// comment 출력 함수 : comment정보를 읽어와서 table에 추가
function load_comment(){
	let board_seq=$("#board_seq").val();
	$.ajax({
		url:"<%=request.getContextPath()%>/comment/list",
		data:{board_seq:board_seq},
		dataType:"JSON"
	})
	.done((res)=>{
		console.log(res);
		data = res.data;
		// commentList = res.commentList;
		// 기존에 들어가 있던 데이터는 미리 삭제해서 비워줌
		for(i=$("#cmtList>tbody>tr").length; i>-1; i--){
			$("#cmtList>tbody>tr:last").remove();	// 맨 마지막 요소부터 삭제
		}
		data.forEach((item)=>{		
			$("#cmtList > tbody").append("<tr><td>" +item.userid+"	" + item.comments + "	" + item.regdate+"</td></tr>");
			})
		})
		.fail((res, status, error)=>{
			console.log(error);
		})
}
<%-- 	
(onclick event)
function goList(){
		var frm=document.myform;
		frm.action="<%=request.getContextPath()%>/board/list";
		frm.method="POST";
		frm.submit();
	} --%>
</script>