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
                    <h1>Chart</h1>
                    <h2>Product</h2>
                </div>
            </div>   
            <table>
                <td valign="top">
                    <div class="content">

                        
                    </div>
                </td>
            </table>
        </div>
        <!-- Foot -->
        <%@include file="include/foot.jspf"  %>           
    </body>
</html>