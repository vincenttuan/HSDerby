<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html>
    <head>
        <!-- head -->
        <%@include file="include/head.jspf"  %>
    </head>
    <body>
        <div id="layout">
            <!-- Menu toggle -->
            <%@include file="include/toggle.jspf"  %>

            <!-- Menu -->
            <%@include file="include/menu.jspf"  %>

            <div id="main">
                <div class="header">
                    <h1>Micro Market</h1>
                    <h2>Micro Market</h2>
                </div>
            </div>
            <table>
                <td valign="top">
                    <div class="content">
                        <form:form modelAttribute="microMarket" class="pure-form" action="/HSDerby/mvc/micro_market/${action}">
                            <fieldset>
                                <legend> <h2 class="content-subhead">市場區域維護</h2></legend>

                                <form:input path="zipCode" placeholder="區域碼" readonly="${readonly}" /><p />
                                <form:input path="radius" placeholder="區域半徑" /><p />
                                <form:input path="areaLength" placeholder="區域長度" /><p />
                                <form:input path="areaWidth" placeholder="區域寬度" /><p />

                                <button type="submit" class="pure-button pure-button-primary">${action}</button>
                            </fieldset>
                        </form:form>
                    </div>
                </td>    
                <td valign="top">    
                    <div class="content">
                        <form class="pure-form">
                            <fieldset>
                                <legend><h2 class="content-subhead">市場區域列表</h2></legend>
                                <table class="pure-table pure-table-bordered">
                                    <thead>
                                        <tr>
                                            <th>修改</th>
                                            <th>刪除</th>
                                            <th>zipCode</th>
                                            <th>radius</th>
                                            <th>areaLength</th>
                                            <th>areaWidth</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <c:forEach var="item" items="${list}">
                                            <tr>
                                                <td><a href="/HSDerby/mvc/micro_market/get/${item.zipCode}">按我修改</a></td>
                                                <td><a href="/HSDerby/mvc/micro_market/delete/${item.zipCode}">按我刪除</a></td>
                                                <td>${item.zipCode}</td>
                                                <td>${item.radius}</td>
                                                <td>${item.areaLength}</td>
                                                <td>${item.areaWidth}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table> 
                            </fieldset>
                        </form>
                    </div>    
                </td>
            </table>
        </div>
        <!-- Foot -->
        <%@include file="include/foot.jspf"  %>      
    </body>
</html>
