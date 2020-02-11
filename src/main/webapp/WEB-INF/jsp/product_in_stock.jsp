<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<!doctype html>
<html>
    <head>
        <!-- head -->
        <%@ include file="include/head.jspf"  %>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script>
            google.charts.load('current', {packages: ['corechart', 'gauge']});
            google.charts.setOnLoadCallback(drawBasic);

            function drawBasic() {

                var data = google.visualization.arrayToDataTable([
                    ['商品', '數量', ],
                    ['面膜', 80],
                    ['酒精', 50],
                    ['口罩', 90]
                ]);

                var options = {
                    title: 'HS 庫存資料',
                    chartArea: {width: '50%'},
                    hAxis: {
                        title: '總數量',
                        minValue: 0
                    },
                    vAxis: {
                        title: '商品'
                    },
                    
                    is3D: true,
                    
                    width: 400, height: 120,
                    redFrom: 90, redTo: 100,
                    yellowFrom: 75, yellowTo: 90,
                    minorTicks: 5
                };
                // BarChart, ColumnChart, PieChart, LineChart
                var chart1 = new google.visualization.BarChart(document.getElementById('chart_div1'));
                chart1.draw(data, options);
                var chart2 = new google.visualization.ColumnChart(document.getElementById('chart_div2'));
                chart2.draw(data, options);
                var chart3 = new google.visualization.PieChart(document.getElementById('chart_div3'));
                chart3.draw(data, options);
                var chart4 = new google.visualization.LineChart(document.getElementById('chart_div4'));
                chart4.draw(data, options);
                var chart5 = new google.visualization.Gauge(document.getElementById('chart_div5'));
                chart5.draw(data, options);

            }
        </script>
    </head>
    <body>
        <div id="layout">
            <!-- Menu toggle -->
            <%@ include file="include/toggle.jspf"  %>

            <!-- Menu -->
            <%@ include file="include/menu.jspf"  %>

            <div id="main">
                <div class="header">
                    <h1>Product in stock</h1>
                    <h2>商品庫存統計</h2>
                </div>
            </div>
            <table>
                <td valign="top">
                    <div class="content">
                        <!-- 統計圖表位置 --> 
                        <table>
                            <tr>
                                <td><div id="chart_div1"></div></td>
                                <td><div id="chart_div2"></div></td>
                            </tr>
                            <tr>
                                <td><div id="chart_div3"></div></td>
                                <td><div id="chart_div4"></div></td>
                            </tr>
                            <tr>
                                <td colspan="2"><div id="chart_div5"></div></td>
                            </tr>
                        </table>

                    </div>
                </td>
            </table>
        </div>
        <!-- Foot -->
        <%@include file="include/foot.jspf"  %>           
    </body>
</html>