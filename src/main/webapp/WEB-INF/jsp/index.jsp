<%@ page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <h1>Derby</h1>
                    <h2>Sample Tables</h2>
                </div>
                
                <img src="/HSDerby/images/derby.png">
                
            </div>
        </div>
        <!-- Foot -->
        <%@include file="include/foot.jspf"  %>   
    </body>
</html>
