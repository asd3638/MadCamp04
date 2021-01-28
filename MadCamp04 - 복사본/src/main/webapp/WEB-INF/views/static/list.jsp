<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="/resources/vendor/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<style>
		.mySlides {display:none}
		.w3-left, .w3-right, .w3-badge {cursor:pointer; color:black}
		.w3-badge {height:13px;width:13px;padding:0; color:black}
	</style>
</head>

<body>
    <div class="row">
                <div class="col-lg-12" style = "height:1800px;">
                
                
                <div class="w3-container">
					  
					
					<div class="w3-content w3-display-container" style="max-width:800px; height:500px;">
					  <img class="mySlides" src="/resources/images/2.jpg" style="width:100%; height:500px;">
					  <img class="mySlides" src="/resources/images/qwe.jpg" style="width:100%; height:500px;">
					  <img class="mySlides" src="/resources/images/spring.png" style="width:100%; height:500px;">
					  <div class="w3-center w3-container w3-section w3-large w3-text-white w3-display-bottommiddle" style="width:100%">
					    <div class="w3-left w3-hover-text-khaki" onclick="plusDivs(-1)">&#10094;</div>
					    <div class="w3-right w3-hover-text-khaki" onclick="plusDivs(1)">&#10095;</div>
					    <span class="w3-badge demo w3-border w3-transparent w3-hover-white" onclick="currentDiv(1)"></span>
					    <span class="w3-badge demo w3-border w3-transparent w3-hover-white" onclick="currentDiv(2)"></span>
					    <span class="w3-badge demo w3-border w3-transparent w3-hover-white" onclick="currentDiv(3)"></span>
					  </div>
					</div>
                    <h1 class="page-header">어떤 것을 공부할까?</h1>
                </div>
               		<div class="flot-chart">
									<form role = "form" method = "get" action = "/learn">
										<div class="flot-chart-content" id = "test-flot" style = "width:600px; height:600px;  margin : auto; margin-top:20px;"></div>
									</form>
                    </div>
                    <h3 style = "position:absolute; margin-top: 200px">시험~qweqwdsaaaaaaaaaaasddddddddddddddddddddddddddddddddddddddddddddddd</br>aaaaaaaaaaaaaaaaawwwwwwwwww</h3>
                <div class="col-lg-12" style = "height:1200px;">
                    <h1 class="page-header">Tiobe 설문 결과</h1>
                </div>     
                    <div class="flot-chart">
									<form role = "forming" method = "get" action = "/learn">
										<div class="flot-chart-content" id = "tiobe-flot" style = "width:600px; height:600px;  margin : auto; margin-top:400px;"></div>
									</form>
                    </div>
                    
                    <div class="col-lg-12" style = "height:1200px;">
                    <h1 class="page-header">StackOverFlow 설문 결과</h1>
                    <div id="barchart_values" class = "row justify-content-center" align = "center" style = "margin-top:-50	px"></div>
                    
            </div>
            <!-- /.row -->
            
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="/resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Flot Charts JavaScript -->
    <script src="/resources/vendor/flot/excanvas.min.js"></script>
    <script src="/resources/vendor/flot/jquery.flot.js"></script>
    <script src="/resources/vendor/flot/jquery.flot.pie.js"></script>
    <script src="/resources/vendor/flot/jquery.flot.resize.js"></script>
    <script src="/resources/vendor/flot/jquery.flot.time.js"></script>
    <script src="/resources/vendor/flot-tooltip/jquery.flot.tooltip.min.js"></script>
    <script src="/resources/data/flot-data.js"></script>
    
    <script src="/resources/vendor/raphael/raphael.min.js"></script>
    <script src="/resources/vendor/morrisjs/morris.min.js"></script>
    <script src="/resources/data/morris-data.js"></script>
    
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    
    <script type = "text/javascript">
    $(function() {
    	//var infoList = '${crawlingInfo.get('10')}';
    	var data = [];
    	data.push({label: '${crawlingInfo[0].name}', data : '${crawlingInfo[0].number}'});
    	data.push({label: '${crawlingInfo[4].name}', data : '${crawlingInfo[4].number}'});
    	data.push({label: '${crawlingInfo[8].name}', data : '${crawlingInfo[8].number}'});
    	data.push({label: '${crawlingInfo[12].name}', data : '${crawlingInfo[12].number}'});
    	data.push({label: '${crawlingInfo[16].name}', data : '${crawlingInfo[16].number}'});
    	data.push({label: '${crawlingInfo[20].name}', data : '${crawlingInfo[20].number}'});
    	data.push({label: '${crawlingInfo[24].name}', data : '${crawlingInfo[24].number}'});
    	data.push({label: '${crawlingInfo[28].name}', data : '${crawlingInfo[28].number}'});
    	data.push({label: '${crawlingInfo[32].name}', data : '${crawlingInfo[32].number}'});
    	data.push({label: '${crawlingInfo[36].name}', data : '${crawlingInfo[36].number}'});
    	data.push({label: '${crawlingInfo[40].name}', data : '${crawlingInfo[40].number}'});

    	var formObj = $("form");
    	
        $.plot($("#test-flot"), data, {
            series: {
                pie: {
                    show: true,
                    radius : 1,
                    tilt: 1,
                    label:{
                    	radius:3/4,
                    	formatter: function (label, series) {
                            return '<div " style="font-size:8pt;text-align:center;padding:5px;color:white;">' + label + '<br/>' +   
                             Math.round(series.percent) + '%</div>';
                       },
                    }
                }
            },
            legend:{
            	show:false
            },
            grid: {
                hoverable: true,
                clickable: true
            },
            tooltip: true,
            tooltipOpts: {
                content: "%p.0%, %s", // show percentages, rounding to 2 decimal places
                shifts: {
                    x: 20,
                    y: 0
                },
                defaultTheme: false
            }
            
           
        });
        $("#test-flot").bind("plotclick", function(event, pos, obj){
        	if (!obj){return;}
        	formObj.attr("action", "/static/learn").attr("method","get");
       		formObj.submit();
        	
        });    
        $(".pieLabel").click(function() {  });
	
        $('.pieLabel').bind('click',function(e){
            $("#flotcontainer .flot-overlay").trigger(e);
        });
    });
    </script>
    <script type = "text/javascript">
    $(function() {
    	//var infoList = '${crawlingInfo.get('10')}';
    	var data = [];
    	data.push({label: "c", data : 17.38});
    	data.push({label: "java", data : 11.96});
    	data.push({label: "python", data : 11.72});
    	data.push({label: "c++", data : 7.56});
    	data.push({label: "c#", data : 3.95});
    	data.push({label: "visual basic", data : 3.84});
    	data.push({label: "javascript", data : 2.20});
    	data.push({label: "PHP", data : 1.99});
    	data.push({label: "R", data : 1.84});
    	data.push({label: "groovy", data : 1.64});
    	data.push({label: "assembly", data : 1.61});

    	var formObj = $("forming");
    	
        $.plot($("#tiobe-flot"), data, {
            series: {
                pie: {
                    show: true,
                    radius : 1,
                    tilt: 1,
                    label:{
                    	radius:3/4,
                    	formatter: function (label, series) {
                            return '<div " style="font-size:8pt;text-align:center;padding:5px;color:white;">' + label + '<br/>' +   
                             Math.round(series.percent) + '%</div>';
                       },
                    }
                }
            },
            legend:{
            	show:false
            },
            grid: {
                hoverable: true,
                clickable: true
            },
            tooltip: true,
            tooltipOpts: {
                content: "%p.0%, %s", // show percentages, rounding to 2 decimal places
                shifts: {
                    x: 20,
                    y: 0
                },
                defaultTheme: false
            }
            
           
        });
        $("#tiobe-flot").bind("plotclick", function(event, pos, obj){
        	if (!obj){return;}
        	formObj.attr("action", "/static/learn").attr("method","get");
       		formObj.submit();
        	
        });    
        $(".pieLabel").click(function() {  });
	
        $('.pieLabel').bind('click',function(e){
            $("#flotcontainer .flot-overlay").trigger(e);
        });
    });

    
    </script>
	
	<script type="text/javascript">
    google.charts.load("current", {packages:["corechart"]});
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {
      var data = google.visualization.arrayToDataTable([
        ["Element", "선호도", { role: "style" } ],
        ["JavaScript", 67.7, "gold"],
        ["HTML/CSS", 63.1, "gold"],
        ["SQL", 54.7, "gold"],
        ["Python", 44.1, "gold"],
        ["Java", 40.2, "gold"],
        ["Bash/Shell", 33.1, "gold"],
        ["C#", 31.4, "gold"],
        ["PHP", 26.2, "gold"],
        ["TypeScript", 25.4, "gold"],
        ["C++", 23.9, "gold"]
      ]);

      var view = new google.visualization.DataView(data);
      
      var options = {
        width: 1200,
        height: 800,
        bar: {groupWidth: "95%"},
        legend: { position: "none" }
        
      };
      var chart = new google.visualization.BarChart(document.getElementById("barchart_values"));
      chart.draw(view, options);
  }
  </script>
	<script>
		var slideIndex = 1;
		showDivs(slideIndex);
		
		function plusDivs(n) {
		  showDivs(slideIndex += n);
		}
		
		function currentDiv(n) {
		  showDivs(slideIndex = n);
		}
		
		function showDivs(n) {
		  var i;
		  var x = document.getElementsByClassName("mySlides");
		  var dots = document.getElementsByClassName("demo");
		  if (n > x.length) {slideIndex = 1}
		  if (n < 1) {slideIndex = x.length}
		  for (i = 0; i < x.length; i++) {
		    x[i].style.display = "none";  
		  }
		  for (i = 0; i < dots.length; i++) {
		    dots[i].className = dots[i].className.replace(" w3-white", "");
		  }
		  x[slideIndex-1].style.display = "block";  
		  dots[slideIndex-1].className += " w3-white";
		}
	</script>
  
	
    <!-- Custom Theme JavaScript -->
    <script src="/resources/dist/js/sb-admin-2.js"></script>
   

</body>

</html>
