<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<h1 class="text-center" style="text-bold";>일별 통계 페이지</h1>

<div class="container">
        <div class="row my-3">
            <div class="col-12">
                <h4>OTT별 생성된 방 통계</h4>
            </div>
        </div>
        <div class="row my-2">
            <div class="col-lg-6">
                <div class="card">
                    <div class="card-body">
                        <canvas id="myChart1"></canvas>
                    </div>
                    <div class="card-footer text-center text-dark">
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <div class="container">
        <div class="row my-3">
            <div class="col">
                <h4>OTT별 생성된 방 통계</h4>
            </div>
        </div>
        <div class="row py-2">
            <div class="col-md-4 py-1">
                <div class="card">
                    <div class="card-body">
                        <canvas id="chDonut1"></canvas>
                    </div>
                </div>
            </div>
        </div>
      </div>

</body>

<script type="text/javascript">

data = {
        datasets: [{
            backgroundColor: ['red','yellow','blue'],
            data: [10, 20, 30]
        }],       
        // 라벨의 이름이 툴팁처럼 마우스가 근처에 오면 나타남
        labels: ['red','yellow','blue'] 
    };

  // 가운데 구멍이 없는 파이형 차트
  var ctx1 = document.getElementById("myChart1");
  var myPieChart = new Chart(ctx1, {
      type: 'pie',
      data: data,
      options: {}
  });

  var colors = ['red','skyblue','yellowgreen','#c3e6cb','#dc3545','#6c757d'];

  /* 3 donut charts */
  var donutOptions = {
    cutoutPercentage: 30, //도넛두께 : 값이 클수록 얇아짐
    legend: {position:'bottom', padding:5, labels: {pointStyle:'circle', usePointStyle:true}}
  };

  // donut 1
  var chDonutData1 = {
      labels: ['Netflix', 'Disney+', 'Other'],
      datasets: [
        {
          backgroundColor: colors.slice(0,3),
          borderWidth: 0,
          data: [74, 11, 40]
        }
      ]
  };

  var chDonut1 = document.getElementById("chDonut1");
    if (chDonut1) {
      new Chart(chDonut1, {
        type: 'pie',
        data: chDonutData1,
        options: donutOptions
    });
  }

  
</script>

</html>