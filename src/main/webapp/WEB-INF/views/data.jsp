<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Java API for WebSocket (JSR-356)</title>
</head>
<body>
<script type="text/javascript" src="http://120.77.144.115:8080/js/jquery.min.js"></script>
<script type="text/javascript" src="http://120.77.144.115:8080/js/sockjs-0.3.4.min.js"></script>
<script type="text/javascript">

    var websocket = null;
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://120.77.144.115:8080/websocket/webSocketServer.do");
    } else if ('MozWebSocket' in window) {
        websocket = new MozWebSocket("ws://120.77.144.115:8080/websocket/webSocketServer.do");
    } else {
        websocket = new SockJS("http://120.77.144.115:8080/hp/sockjs/webSocketServer.do");
    }
    websocket.onopen = onOpen;
    websocket.onmessage = onMessage;
    websocket.onerror = onError;
    websocket.onclose = onClose;

    function onOpen(openEvt) {
        //alert(openEvt.Data);
    }

    var i = 1;

    function onMessage(evt) {
        // var group = [{name: "1班"},
        //     {name: "2班"},
        //     {name: "3班"},
        //     {name: "4班"},
        //     {name: "5班"},
        //     {name: "6班"},
        //     {name: "7班"}]
        //
        //
        // var groupTable = $('#group');
        // for (var i = 1; i <= group.length; i++) {
        //     var item = group[i - 1]
        //     groupTable.append('<tr> ' +
        //         '<td class="tdClass">' + i + '</td>' +
        //         '<td class="tdClass">' + item.name + '</td>' +
        //         '</tr>')
        // }
        alert(evt.data);

        var groupTable = $('#group');
        groupTable.prepend('<tr> ' +
            '<td class="tdClass">' + "" + '</td>' +
            '<td class="tdClass">' + evt.data + '</td>' +
            '</tr>')
        i++;
        if (i == 20) {
            $('table tr:last').remove();
            i = 19;
        }

    }

    function onError() {
    }

    function onClose() {
    }

    function doSend() {
        if (websocket.readyState == websocket.OPEN) {
            var msg = document.getElementById("inputMsg").value;
            websocket.send(msg);//调用后台handleTextMessage方法
            alert("发送成功!");
        } else {
            alert("连接失败!");
        }
    }
</script>
<%--请输入：<textarea rows="5" cols="10" id="inputMsg" name="inputMsg"></textarea>--%>
<%--<button onclick="doSend();">发送</button>--%>

<table id="group"
       style="width: 80vw;display: flex;margin: auto;font-size: 2.0vw;text-align: left;border-collapse:collapse; border: 1px solid  red">
    <tr>
        <td class="tdClass"></td>
        <td class="tdClass"></td>
    </tr>
</table>
</body>
</html>
