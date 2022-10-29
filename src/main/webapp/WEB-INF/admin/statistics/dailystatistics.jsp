<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<%	int netflix = (int)request.getAttribute("netflix"); %>
<%	int disney = (int)request.getAttribute("disney"); %>
<%	int tving = (int)request.getAttribute("tving"); %>
<%	int apple = (int)request.getAttribute("apple"); %>
<%	int wave = (int)request.getAttribute("wave"); %>
<%	int watcha = (int)request.getAttribute("watcha"); %>
<%	int laftel = (int)request.getAttribute("laftel"); %>
<%	int nuser  = (int)request.getAttribute("nuser"); %>
<%	int duser  = (int)request.getAttribute("duser"); %>
<%	int partycre  = (int)request.getAttribute("partycre"); %>
<%	int partyend  = (int)request.getAttribute("partyend"); %>

<div style="margin-left:480px;">
	<h1 style="margin: 30px 0;">당일 통계 페이지</h1>
</div>

<hr style="width: 1000px; margin: 30px auto; border:0; height:2px; background: #ccc;">

<div style="position:relative; width:1000px; margin: 0 auto;">
	<h2 class="text-center" style="margin-top: 30px; margin-bottom: 20px; font-size: 20px; font-weight: bold;">
		OTT별 생성된 방 통계</h2>
	<div> <canvas id="myChart1" style="width: 1000px; height: 500px;"></canvas>	</div>
	
<hr style="width: 1000px; margin: 30px auto; border:0; height:1px; background: #ccc;">
	
	<h2 class="text-center" style="margin-top: 30px; margin-bottom: 20px; font-size: 20px; font-weight: bold;">
			회원 통계</h2>
	<div> <canvas id="myChart2" style="width: 1000px; height: 500px;"></canvas>	</div>

<hr style="width: 1000px; margin: 30px auto; border:0; height:1px; background: #ccc;">

	<h2 class="text-center" style="margin-top: 30px; margin-bottom: 20px; font-size: 20px; font-weight: bold;">
			파티 통계</h2>
	<div style="margin-bottom: 100px;"> <canvas id="myChart3" style="width: 1000px; height: 500px;"></canvas>	</div>
</div>


</body>


<script type="text/javascript">

var ctx = document.getElementById('myChart1');
var myChart = new Chart(ctx, {
  type: 'bar',
  data: {
    labels: ['넷플릭스', '디즈니플러스', '티빙', '애플', '웨이브', '왓챠', '라프텔'],
    datasets: [{
      	label: 'OTT별 통계',
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
//     		max: 20,
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

var ctx = document.getElementById('myChart2');
var myChart = new Chart(ctx, {
  type: 'bar',
  data: {
    labels: ['신규 가입 회원', '탈퇴 회원'],
    datasets: [{
      	label: '회원 통계',
      	data: [<%=nuser %>, <%=duser %>],
      	backgroundColor: [
	        'rgba(255, 99, 132, 0.2)',
	        'rgba(54, 162, 235, 0.2)',
	    ],
	    borderColor: [
	    	'rgba(255, 99, 132, 1)',
	        'rgba(54, 162, 235, 1)',
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
//     		max: 20,
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

var ctx = document.getElementById('myChart3');
var myChart = new Chart(ctx, {
  type: 'bar',
  data: {
    labels: ['신규 개설 파티', '종료된 파티'],
    datasets: [{
      	label: '파티 통계',
      	data: [<%=partycre %>, <%=partyend %>],
      	backgroundColor: [
	        'rgba(122, 88, 233, 0.2)',
	        'rgba(255, 159, 64, 0.2)'
	    ],
	    borderColor: [
	        'rgba(122, 88, 233, 1)',
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
//     		max: 20,
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

<!-- 부트스트랩3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
@import url('https://webfontworld.github.io/sunn/SUIT.css');
body{
	font-family: 'SUIT';
}
</style>

</html>