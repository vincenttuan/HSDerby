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
    </head>
    <body>
        <div id="layout">
            <!-- Menu toggle -->
            <%@ include file="include/toggle.jspf"  %>

            <!-- Menu -->
            <%@ include file="include/menu.jspf"  %>

            <div id="main">
                <div class="header">
                    <h1>Member</h1>
                    <h2>會員資料</h2>
                </div>
            </div>
            <table>
                <td valign="top">
                    <div class="content">
                        <form class="pure-form">
                            <fieldset>
                                <legend><h2 class="content-subhead">會員列表</h2></legend>
                                <table class="pure-table pure-table-bordered">
                                    <thead>
                                        <tr>
                                            <th>id</th>
                                            <th>base64</th>
                                            <th>username</th>
                                            <th>password</th>
                                            <th>email</th>
                                            <th>code</th>
                                            <th>pass</th>
                                            <th>passts</th>
                                            <th>priority</th>
                                            <th>ts</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <c:forEach var="item" items="${list}">
                                            <tr>
                                                <td>${item.id}</td>
                                                <td><img width="100" src="${item.base64}"></td>
                                                <td>${item.username}</td>
                                                <td>${item.password}</td>
                                                <td>${item.email}</td>
                                                <td>${item.code}</td>
                                                <td>${item.pass}</td>
                                                <td>${item.passts}</td>
                                                <td>${item.priority}</td>
                                                <td>${item.ts}</td>
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