<%--
  Created by IntelliJ IDEA.
  User: thiss
  Date: 22/3/2018
  Time: 6:56 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
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
  <style>
    th, td {
      padding-left: 15px;
      padding-right: 15px;
    }
  </style>

</head>
<body>

<div class="container">

  <div class="row">

    <div class="col-md-6 col-md-offset-3" style="margin-top: 40px; margin-bottom: 40px">

      <div class="input-group">
        <input type="text" id="message" class="form-control" placeholder="Type your message..."
               aria-describedby="basic-addon2">
        <span class="input-group-btn"><button id="btn" class="btn btn-success" onclick="say()">Send</button></span>
      </div>

      <%--<label style="padding-left: 15px; padding-right: 15px" for="message">Message</label>--%>
      <%--<div class="form-row">--%>
      <%--<div class="col-md-6">--%>
      <%--<input class="form-control" id="message" name="message">--%>
      <%--</div>--%>
      <%--<div class="col-md-6">--%>
      <%--<button  style="width: 100px" class="btn btn-success btn-large" id="btn" onclick="say()">Say</button>--%>
      <%--</div>--%>
      <%--</div>--%>

    </div>

  </div>


  <table cellpadding="10" cellspacing="10"
         class="table table-bordered table-hover">
    <thead>
    <tr>
      <th>Time</th>
      <th>ID</th>
      <th>Message</th>
    </tr>
    </thead>
    <tbody id="chat">
    </tbody>

  </table>

</div>

<script>
    let socket = new WebSocket("ws://127.0.0.1:8080${pageContext.request.contextPath}/chat");
    socket.onmessage = onMessage;

    //    socket.onopen = function (event) {
    //        chat.innerHTML = 'Connected to: ' + event.currentTarget.url;
    //        chat.className = 'open';
    //    };
    //
    //    socket.onerror = function (error) {
    //        chat.innerHTML += 'WebSocket Error: ' + error;
    //    };
    //
    //    socket.onclose = function () {
    //        chat.innerHTML += 'Disconnected from WebSocket.';
    //    };

//    let closeBtn = document.getElementById("btn1");
//    closeBtn.onclick = function (e) {
//        e.preventDefault();
//
//        // Close the WebSocket.
//        socket.close();
//
//        return false;
//    };

    let input = document.getElementById("message");
    let chat = document.getElementById("chat");

    function onMessage(event) {
        let message = JSON.parse(event.data);
        let id = message.id.substring(0, 5);

        let td1 = document.createElement("td");
        let time = document.createTextNode(message.time_sent);
        td1.appendChild(time);

        let td2 = document.createElement("td");
        let idt = document.createTextNode(id);
        td2.appendChild(idt);

        let td3 = document.createElement("td");
        let m = document.createTextNode(message.mes);
        td3.appendChild(m);


        let tdr = document.createElement("tr");
        tdr.appendChild(td1);
        tdr.appendChild(td2);
        tdr.appendChild(td3);

        chat.appendChild(tdr);

//        chat.innerHTML += ('<tr>');
//        chat.innerHTML += ('<td>' + id + '</td>');
//        chat.innerHTML += ('<td>' + message.message + '</td>');
//        chat.innerHTML += ('<td>' + message.time + '</td>');
//        chat.innerHTML += ('</tr>');
    }

    function say() {
        let text = input.value;
        if (text.length > 0) {
            socket.send(text);
            input.value = "";
        }
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
