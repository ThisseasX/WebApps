<%--
  Created by IntelliJ IDEA.
  User: thiss
  Date: 13/2/2018
  Time: 3:51 πμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LoginTest</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container my-3">
    <h1 class="jumbotron">Welcome to ThissBank</h1>
    <form method="post" action="${pageContext.request.contextPath}/LoginServlet" class="col-md-6 mx-auto">
        <div class="form-group">
            <label for="username">Username</label>
            <input name="username" class="form-control" id="username" placeholder="Username">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input name="password" type="password" class="form-control" id="password" placeholder="Password">
        </div>
        <button class="btn btn-primary">Sign in</button>
        <br><br>
        <%
            if (request.getAttribute("wrong") == "true") {
        %>
        <small id="warning" style="color: red">Wrong username or password!</small>
        <%
            }
        %>
    </form>
</div>

<script src="http://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
</body>
</html>
