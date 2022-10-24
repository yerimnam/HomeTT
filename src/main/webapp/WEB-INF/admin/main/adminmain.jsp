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
    
<%@ include file="../layout/header.jsp" %>

<h2 style="text-align: center;">어드민 메인</h2>

<div style="left: 500px; margin: 0px auto;">
<!-- 	월 통계 요약 -->
</div>
<div style="width:1500px; margin: 40px auto; display: flex;">
	<div>
		<canvas id="myChart1" style="width: 400px; height: 400px; margin: 100px auto; margin-right:100px;"></canvas>
	</div>
	<div> 
		<canvas id="myChart2" style="width: 1000px; height: 500px;"></canvas>
	</div>
</div>


</body>

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
        	label: '넷플릭스',
        	data: [<%=netflix %>, <%=disney %>, <%=tving %>, <%=apple %>, <%=wave %>, <%=watcha %>, <%=laftel %>],
        	backgroundColor: [
  	        'rgba(255, 99, 132, 0.2)',
  	        'rgba(54, 162, 235, 0.2)',
  	        'rgba(255, 206, 86, 0.2)',
  	        'rgba(75, 192, 192, 0.2)',
  	        'rgba(153, 102, 255, 0.2)',
  	        'rgba(122, 88, 233, 0.2)',
  	        'rgba(255, 159, 64, 0.2)'
  	    ],
  	    borderColor: [
  	    	'rgba(255, 99, 132, 1)',
  	        'rgba(54, 162, 235, 1)',
  	        'rgba(255, 206, 86, 1)',
  	        'rgba(75, 192, 192, 1)',
  	        'rgba(153, 102, 255, 1)',
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
      		max: 20,
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

</html>