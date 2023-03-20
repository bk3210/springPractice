<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.kosa.mycompany.home.*"%>
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
	<form name="myform" id="myform">

		<!-- Carousel -->
		<div id="myCarousel" class="carousel slide" data-bs-ride="carousel">

			<!-- Indicators/dots -->
			<div class="carousel-indicators" id="indicator">
				<button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0"
					class="active"></button>
				<button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1"></button>
				<button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2"></button>
				<button type="button" data-bs-target="#myCarousel" data-bs-slide-to="3"></button>
				<button type="button" data-bs-target="#myCarousel" data-bs-slide-to="4"></button>
				<button type="button" data-bs-target="#myCarousel" data-bs-slide-to="5"></button>
			</div>

			<!-- The slideshow/carousel -->
			<div id="thisCarousel"></div>

			<!-- Left and right controls/icons -->
			<button class="carousel-control-prev" type="button"
				data-bs-target="#myCarousel" data-bs-slide="prev">
				<span class="carousel-control-prev-icon"></span>
				<span class="sr-only">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#myCarousel" data-bs-slide="next">
				<span class="carousel-control-next-icon"></span>
				<span class="sr-only">Next</span>
			</button>
		</div>
	</form>
</body>
<script>

$(()=>{
	load_data();
})

function load_data(){
	let temp = "";
	$.ajax({
		url:"<%=request.getContextPath()%>/home/list_data",
		dataType:"JSON"
	})
	for(i=0; i<7; i++){
		
	}
	.done((res)=>{
		// console.log(res);
		data=res.data
		res.data.forEach((item)=>{	// 데이터 추가(배열형태라 forEach 사용)
			temp="<tr><td>"+item.m_id+"</td>";
			tr+="<td>"+item.m_userid+"</td>";
			tr+="<td>"+item.m_name+"</td>";
			tr+="<td>"+item.m_email+"</td>";
			tr+="<td>"+item.m_phone+"</td></tr>";
			console.log(tr);
			$("#mytable > tbody:last").append(tr);	
		})
	})
		console.log(temp);
		$("#myCarousel").html(temp);	// 출력
	})
	.fail((res, status, error)=>{
		console.log(status);
		console.log(error);
	});
}
</script>