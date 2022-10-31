<%@page import="admin.report.dto.Report"%>
<%@page import="admin.cs.inquiry.dto.Inquiry"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	int netflix = (int)request.getAttribute("netflix"); %>
<%	int disney = (int)request.getAttribute("disney"); %>
<%	int tving = (int)request.getAttribute("tving"); %>
<%	int apple = (int)request.getAttribute("apple"); %>
<%	int wave = (int)request.getAttribute("wave"); %>
<%	int watcha = (int)request.getAttribute("watcha"); %>
<%	int laftel = (int)request.getAttribute("laftel"); %>
<%	int partycre  = (int)request.getAttribute("partycre"); %>
<%	int partyend  = (int)request.getAttribute("partyend"); %>
<%	List<Inquiry> inquiryList = (List) request.getAttribute("inquiryList"); %>
<%	List<Report> reportList = (List) request.getAttribute("reportList"); %>

<%@ include file="../layout/header.jsp" %>

<h1 class="text-center">어드민 메인</h1>

<hr style="width: 1500px; margin: 30px auto; border:0; height:2px; background: #ccc;">

<div style="margin: 0 0 -10px 360px;">
	<h2>월 통계 요약</h2>
</div>
<div style="width:1500px; margin: 10px auto; display: flex;">
	<div>
		<canvas id="myChart1" style="width: 400px; height: 400px; margin: 100px auto; margin-right:100px;"></canvas>
	</div>
	<div> 
		<canvas id="myChart2" style="width: 1000px; height: 500px;"></canvas>
	</div>
</div>

<hr style="width: 1300px; margin: 10px auto; border:0; height:2px; background: #ccc;">

<div style="margin: 30px 0 0 360px;">
	<h2>1:1 문의 목록</h2>
</div>
<div style="margin: -40px 0 20px 1435px;">
	<button id="btninquiry" class="btn btn-info" style="color: white;">1:1 문의 목록 이동</button>
</div>
<div style="margin-bottom: 40px;">
<table style="width: 1200px;" class="table table-striped table-hover table-condensed">
	<tr>
		<th style="width: 10%; text-align: center">글 번호</th>
		<th style="width: 15%; text-align: center">작성자</th>
		<th style="width: 10%; text-align: center">작성일</th>
		<th style="width: 20%; text-align: center">제목</th>
		<th style="width: 25%; text-align: center">내용</th>
		<th style="width: 10%; text-align: center">답변일</th>
		<th style="width: 10%; text-align: center">처리 상태</th>
	</tr>
<%-- 	<%	for(int i=0; i<inquiryList.size(); i++) { %> --%>
	<%	for(int i=0; i<5; i++) { %>
	<tr>
		<td><%=inquiryList.get(i).getInquiryArticleNumber() %></td>
		<td><%=inquiryList.get(i).getInquiryWriter() %></td>
		<td><%=inquiryList.get(i).getInquiryDate() %></td>
		<td><%=inquiryList.get(i).getInquiryArticleTitle() %></td>
		<%	String content = inquiryList.get(i).getInquiryContent();
			if( content.length() > 15 ) { 
			content = content.substring(0, 15) + "...";
			} %>
		<td>
			<a href="./adinquiryview?inquiryArticleNumber=<%=inquiryList.get(i).getInquiryArticleNumber() %>">
				<%=content %>
			</a>
		</td>
		<td><% if ( inquiryList.get(i).getAnswerDate() != null ) { %>
				<%=inquiryList.get(i).getAnswerDate() %>
			<%	} else { %>
				-
			<%	} %>
		</td>
		<td><% if ( inquiryList.get(i).getAnswerDate() != null ) { %>
					답변 완료
				<% } else {  %>
					답변 대기
				<% };%>
		</td>
		
	</tr>
	<%	} %>
</table>
</div>

<hr style="width: 1300px; margin: 10px auto; border:0; height:2px; background: #ccc;">

<div style="margin: 30px 0 0 360px;">
	<h2>신고 목록</h2>
</div>
<div style="margin: -40px 0 20px 1435px;">
	<button id="btnreport" class="btn btn-info" style="color: white;">신고 목록 이동</button>
</div>
<div style="margin-bottom: 50px;">
<table style="width: 1200px;" class="table table-striped table-hover table-condensed">
	<tr>
		<th style="width: 10%; text-align: center">신고 번호</th>
		<th style="width: 10%; text-align: center">신고 날짜</th>
		<th style="width: 35%; text-align: center">신고 내용</th>
		<th style="width: 15%; text-align: center">신고자</th>
		<th style="width: 15%; text-align: center">신고 대상자</th>
		<th style="width: 20%; text-align: center">신고 파티명</th>
	</tr>
	
<%-- 	<%	for(int i=0; i<reportList.size(); i++) { %> --%>
	<%	for(int i=0; i<5; i++) { %>
	<tr>
		<td><%=reportList.get(i).getReportNo() %></td>
		<td><%=reportList.get(i).getReportDate() %></td>
		<%	String content = reportList.get(i).getReportContent();
			if( content.length() > 15 ) { 
			content = content.substring(0, 15) + "...";
			} %>
		<td>
			<a href="./adreportview?reportno=<%=reportList.get(i).getReportNo() %>">
				<%=content %>
			</a>
		</td>
		<td><%=reportList.get(i).getReporter() %></td>
		<td><%=reportList.get(i).getReportTarget() %></td>
		<td><%=reportList.get(i).getReportParty() %></td>
	</tr>
	<%	} %>
</table>
</div>

</body>

<!-- 부트스트랩3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
@import url('https://webfontworld.github.io/sunn/SUIT.css');
body {
	font-family: 'SUIT';
}
th, td {
 	text-align: center;
 	border: 1px solid #ccc;
}

th {
 	font-size: 16px;
}

* {
 	margin: 0 auto;
}
</style>

<script>
// chart colors
var colors = ['rgba(255, 99, 132, 0.2)','rgba(153, 102, 255, 0.2)'];

/* 3 donut charts */
var donutOptions = {
  cutoutPercentage: 30, //도넛두께 : 값이 클수록 얇아짐
  legend: {position:'bottom', padding:5, labels: {pointStyle:'circle', usePointStyle:true}}
};

// donut 1
var chDonutData1 = {
	labels: ['열린 PARTY','닫힌 PARTY'],
    datasets: [
      {
        backgroundColor: colors.slice(0,3),
        borderWidth: 0,
        data: [<%=partycre %>, <%=partyend %>]
      }
    ]
};

var chDonut1 = document.getElementById("myChart1");
  if (chDonut1) {
    new Chart(chDonut1, {
      type: 'pie',
      data: chDonutData1,
      options: {
    	  donutOptions,
    	  	plugins:{	
    	  		legend: {
//       				display: false,
      			},
    	  	},
      },
  });
}

  var ctx = document.getElementById('myChart2');
  var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
      labels: ['넷플릭스', '디즈니플러스', '티빙', '애플', '웨이브', '왓챠', '라프텔'],
      datasets: [{
        	label: '월 신규 파티',
        	data: [<%=netflix %>, <%=disney %>, <%=tving %>, <%=apple %>, <%=wave %>, <%=watcha %>, <%=laftel %>],
        	backgroundColor: [
  	        'rgba(255, 99, 132, 0.2)',
  	        'rgba(54, 162, 235, 0.2)',
  	        'rgba(255, 206, 86, 0.2)',
  	        'rgba(75, 192, 192, 0.2)',
  	        'rgba(153, 102, 255, 0.2)',
  	        'rgba(102, 138, 107, 0.2)',
  	        'rgba(255, 159, 64, 0.2)'
  	    ],
  	    borderColor: [
  	    	'rgba(255, 99, 132, 1)',
  	        'rgba(54, 162, 235, 1)',
  	        'rgba(255, 206, 86, 1)',
  	        'rgba(75, 192, 192, 1)',
  	        'rgba(153, 102, 255, 1)',
  	        'rgba(102, 138, 107, 1)',
  	        'rgba(255, 159, 64, 1)'
  	    ],
  	    borderWidth: 1
      }]
    },
    options: {
  	  responsive: false,
  	  plugins:{	
  	  		legend: {
  				display: false,
  			},
  	  	},
      scales: {
      	y: {
      		min: 0,
//       		max: 20,
      		ticks: {
      			stepSize: 5,
                  maxTicksLimit: 0,
              },
      	},
      	x: {
      		ticks: {
      			maxTicksLimit: 0,
      		},
      	},
      },
    },
  });
  
</script>

<script type="text/javascript">
$(document).ready(function() {
	
	//1:1문의 목록 이동 버튼
	$("#btninquiry").click(function() {
		$(location).attr('href', './adinquirylist')
	})
	
	//신고 목록 이동 버튼
	$("#btnreport").click(function() {
		$(location).attr('href', './adreportlist')
	})

})
</script>

</html>