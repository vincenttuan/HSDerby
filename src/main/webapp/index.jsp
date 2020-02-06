<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <title>HS Derby</title>
        <!-- head -->
        <%@include file="/WEB-INF/jsp/include/head.jspf"  %>
    </head>
    <body>
        <div id="layout">
            <!-- Menu toggle -->
            <%@include file="/WEB-INF/jsp/include/toggle.jspf"  %>

            <!-- Menu -->
            <%@include file="/WEB-INF/jsp/include/menu.jspf"  %>
            
            <div id="main">
                <div class="header">
                    <h1>Derby</h1>
                    <h2>Sample Tables</h2>
                </div>
                
                <img src="images/derby.png">
                
            </div>
        </div>
        <!-- Foot -->
        <%@include file="/WEB-INF/jsp/include/foot.jspf"  %>   
    </body>
</html>
