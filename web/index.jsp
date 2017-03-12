<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<script>
    var websocket;
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://websocket");
    } else if ('MozWebSocket' in window) {
        websocket = new MozWebSocket("ws://websocket");
    } else {
        websocket = new SockJS("ws://websocket");
    }
    websocket.onopen = function (event) {
        console.log("WebSocket:已连接");
        console.log(event);
    };


</script>
</body>
</html>
