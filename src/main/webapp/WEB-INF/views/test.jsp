<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <style type="text/css">
        form {
            margin: 0px auto;

            width: 500px;
            padding: 20px;
        }
    </style>
    <title></title>

    <script type="text/javascript" language="javascript">
        var websocket;

        function init() {
            output = document.getElementById("output");
        }

        function send() {
            // var wsUri = "ws://120.77.144.115:8080/hpnew_war/hp307";
            var wsUri = "ws://127.0.0.1:8085/hp/hp307";
            writeToScreen("Connecting to : " + wsUri);
            websocket = new WebSocket(wsUri);
            websocket.onopen = function (evt) {
                writeToScreen("Connect Success!");
                doSend(document.getElementById("textID").value);
            };
            // websocket.onmessage = function (evt) {
            //     writeToScreen("Received Message: " + evt.data);
            //     websocket.close();
            // };
            websocket.onerror = function (evt) {
                writeToScreen('<span style="color:red;">ERROR:</span>' + evt.data);
            };
        }

        function doSend(message) {
            websocket.send(message);
            writeToScreen("Send Message : " + message);
        }

        function writeToScreen(message) {
            var pre = document.createElement("p");
            pre.style.wordWrap = "break-word";
            pre.innerHTML = message;
            output.appendChild(pre)
        }

        window.addEventListener("load", init, false);

    </script>
</head>

<body>
<h1>Http get请求测试</h1>
<form action="/info" method="get">
    id：<input name="collect_data"/> <br/>
    <input type="submit" value="save"/>
</form>


<h1>websocket数据测试</h1>


<div style="text-align:left;">
    <form action="">
        <input onclick="send()" value="Send Message" type="button">
        <input id="textID" name="message" value="Hello Web Socket" type="text">
        <br>
    </form>

</div>
<div id="output"></div>
</body>
</html>