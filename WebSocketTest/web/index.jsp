<%--
  Created by IntelliJ IDEA.
  User: thiss
  Date: 22/3/2018
  Time: 6:56 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
        integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>

<label for="message">Message</label>
<input id="message" name="message">

<button id="btn" onclick="say()">Say</button>
<button id="btn1">Close</button>

<div id="chat">

</div>

<script>
    let socket = new WebSocket("ws://127.0.0.1:8082/WebSocketTest_war_exploded/chat");
    socket.onmessage = onMessage;

    socket.onopen = function(event) {
        chat.innerHTML = 'Connected to: ' + event.currentTarget.url;
        chat.className = 'open';
    };

    socket.onerror = function(error) {
        chat.innerHTML += 'WebSocket Error: ' + error;
    };

    socket.onclose = function(event) {
        chat.innerHTML += 'Disconnected from WebSocket.';
    };

    let closeBtn = document.getElementById("btn1");
    closeBtn.onclick = function(e) {
        e.preventDefault();

        // Close the WebSocket.
        socket.close();

        return false;
    };

    let input = document.getElementById("message");
    let chat = document.getElementById("chat");

    function onMessage(event) {
        let message = event.data;
        chat.innerHTML += ('<p>' + message + '</p>');
    }

    function say() {
        let text = input.value;
        socket.send(text);
    }

    input.addEventListener("keyup", function (event) {
        event.preventDefault();
        if (event.keyCode === 13) {
            document.getElementById("btn").click();
        }
    });

</script>

</body>
</html>
