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
            google.charts.load('current', {packages: ['corechart']});
            google.charts.setOnLoadCallback(drawChart);
            
            function drawChart() {

                var data = google.visualization.arrayToDataTable([
                    ['商品', '數量'],
                    <c:forEach var="p" items="${list}">
                        ['${p['DESCRIPTION']}', ${p['QUANTITY_ON_HAND']}],        
                    </c:forEach>
                ]);

                var options = {
                    title: 'HS 庫存資料',
                    hAxis: {
                        title: '總數量',
                        minValue: 0
                    },
                    vAxis: {
                        title: '商品'
                    },

                    is3D: true
                };
                // BarChart, ColumnChart, PieChart, LineChart
                var chart1 = new google.visualization.${chart}(document.getElementById('chart_div1'));
                chart1.draw(data, options);
                
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
                    <h1>Chart</h1>
                    <h2>Product</h2>
                </div>
            </div>   
            <table>
                <td valign="top">
                    <div class="content">
                        <a href="/HSDerby/mvc/chart/product/quantity/BarChart">BarChart</a> | 
                        <a href="/HSDerby/mvc/chart/product/quantity/ColumnChart">ColumnChart</a> | 
                        <a href="/HSDerby/mvc/chart/product/quantity/PieChart">PieChart</a> | 
                        <a href="/HSDerby/mvc/chart/product/quantity/LineChart">LineChart</a>
                        
                        <div id="chart_div1" style="width: ${w}px;height: ${h}px"></div>
                        
                        <c:forEach var="p" items="${list}">
                            ${p['DESCRIPTION']}, ${p['QUANTITY_ON_HAND']} <br />
                        </c:forEach>
                        
                    </div>
                </td>
            </table>
        </div>
        <!-- Foot -->
        <%@include file="include/foot.jspf"  %>           
    </body>
</html>