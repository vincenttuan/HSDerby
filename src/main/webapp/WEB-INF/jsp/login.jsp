<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login & Register Page</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css">
        <style>
            #container {
                margin: 0px auto;
                width: 500px;
                height: 375px;
                border: 10px #333 solid;
            }
            #videoElement {
                width: 500px;
                height: 375px;
                background-color: #666;
            }
        </style>
    </head>
    <body style="padding: 50px">
    <center>
        <h1>Login & Register Page</h1>
        <div id="container">
            <video autoplay="true" id="videoElement">

            </video>
        </div>
        <script>
            var video = document.querySelector("#videoElement");

            if (navigator.mediaDevices.getUserMedia) {
                navigator.mediaDevices.getUserMedia({video: true})
                        .then(function (stream) {
                            video.srcObject = stream;
                        })
                        .catch(function (error) {
                            console.log("Something went wrong!");
                        });
            }
        </script>
        <table>
            <td valign="top" style="padding-right: 30px">
                <form:form class="pure-form" modelAttribute="member" method="post" action="/HSDerby/mvc/login/in">
                    <fieldset>
                        <legend>Login</legend>

                        <form:input path="username" placeholder="請輸入 Username" /><p />
                        <form:password path="password" placeholder="請輸入 Password" /><p />

                        <button type="submit" class="pure-button pure-button-primary">Sign in</button>
                    </fieldset>
                </form:form>
            </td>
            <td valign="top" style="padding-left: 30px">
                <form:form class="pure-form" modelAttribute="member" method="post" action="/HSDerby/mvc/login/save">
                    <fieldset>
                        <legend>Register</legend>
                        <form:input path="username" placeholder="請輸入 Username" />&nbsp;&nbsp;<form:errors path="username" style="color: red" /><p />
                        <form:password path="password" placeholder="請輸入 Password" />&nbsp;&nbsp;<form:errors path="password" style="color: red" /><p />
                        <form:input path="email" placeholder="請輸入 Email" type="email" />&nbsp;&nbsp;<form:errors path="email" style="color: red" /><p />
                        <button type="submit" class="pure-button pure-button-primary">Submit</button>
                        <p />
                        <form:errors path="*" />
                    </fieldset>
                </form:form>

            </td>
        </table>
    </center>
</body>
</html>
