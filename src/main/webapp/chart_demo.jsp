<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<!doctype html>
<html>
    <head>
        <!-- head -->
        <%@ include file="/WEB-INF/jsp/include/head.jspf"  %>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script>
            google.charts.load('current', {packages: ['corechart', 'gauge', 'table', 'line']});
            google.charts.setOnLoadCallback(drawChart);

            function drawChart() {
                drawBasic();
                drawTable();
                drawTrendlines();
            }

            function drawBasic() {

                var data = google.visualization.arrayToDataTable([
                    ['商品', '數量'],
                    ['面膜', 80],
                    ['酒精', 50],
                    ['口罩', 90],
                    ['N95', 95],
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

                drawTable();
            }

            function drawTable() {
                var data = new google.visualization.DataTable();
                data.addColumn('string', 'Name');
                data.addColumn('number', 'Amount');
                data.addColumn('number', 'Price');
                data.addColumn('boolean', 'Check');
                data.addRows([
                    ['面膜', {v: 80, f: '80個'}, {v: 10000, f: '$10,000'}, true],
                    ['酒精', 50, {v: 8000, f: '$8,000'}, false],
                    ['口罩', 90, {v: 12500, f: '$12,500'}, true],
                    ['N95', 95, {v: 7000, f: '$7,000'}, true]
                ]);

                var table = new google.visualization.Table(document.getElementById('table_div'));

                table.draw(data, {showRowNumber: true, width: '100%', height: '100%'});
            }

            function drawTrendlines() {
                var data = new google.visualization.DataTable();
                data.addColumn('number', 'X');
                data.addColumn('number', 'Mary');
                data.addColumn('number', 'John');
                data.addColumn('number', 'Jane');

                data.addRows([
                    [1, 10, 5, 4], [2, 23, 15, 10], [3, 17, 9, 8], 
                    [4, 18, 10, 7], [5, 9, 5, 7], [6, 11, 3, 9], 
                    [7, 27, 19, 20], [8, 33, 25, 14], [9, 21, 32, 16], 
                    [10, 10, 24, 21], [11, 5, 27, 12],[12, 1, 22, 17]
                ]);

                var options = {
                    hAxis: {
                        title: 'Time'
                    },
                    vAxis: {
                        title: 'Popularity'
                    },
                    colors: ['#AB0D06', '#007329', '#0000ff'],
                    trendlines: {
                        0: {type: 'linear'}, // 'linear' 線性回歸 , 'exponential'指數分佈, or 'polynomial'多項式回歸.
                        1: {type: 'linear'},
                        2: {type: 'linear'}
                    }
                };

                var chart = new google.visualization.LineChart(document.getElementById('line_div'));
                chart.draw(data, options);
            }
        
        </script>

    </head>
    <body>
        <div id="layout">
            <!-- Menu toggle -->
            <%@ include file="/WEB-INF/jsp/include/toggle.jspf"  %>

            <!-- Menu -->
            <%@ include file="/WEB-INF/jsp/include/menu.jspf"  %>

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
                            <tr>
                                <td colspan="2"><div id="table_div"></div></td>
                            </tr>
                            <tr>
                                <td colspan="2"><div id="line_div"></div></td>
                            </tr>
                        </table>

                    </div>
                </td>
            </table>
        </div>
        <!-- Foot -->
        <%@include file="/WEB-INF/jsp/include/foot.jspf"  %>           
    </body>
</html>