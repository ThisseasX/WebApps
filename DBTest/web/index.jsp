<%--
  Created by IntelliJ IDEA.
  User: thiss
  Date: 28/2/2018
  Time: 9:23 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>DBTest</title>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <style>
    html, body {
      height: 100%;
    }

    html {
      display: table;
      margin: auto;
    }

    body {
      display: table-cell;
      vertical-align: middle;
    }

    .panel {
      background-color: #fff;
      margin: 10px;
    }

  </style>
</head>
<body>


<div class="container">
  <div class="panel panel-default">
    <div class="panel-body">
      <form class="form-group" action="${pageContext.request.contextPath}/db" method="post">
        <table>
          <tr>
            <td><label for="c_afm"> AFM </label></td>
            <td><input class="form-control" id="c_afm" name="c_afm"></td>
          </tr>
          <tr>
            <td><label for="c_name"> Name </label></td>
            <td><input class="form-control" id="c_name" name="c_name"></td>
          </tr>
          <tr>
            <td><label for="c_surname"> Surname </label></td>
            <td><input class="form-control" id="c_surname" name="c_surname"></td>
          </tr>
          <tr>
            <td></td>
            <td><input class="form-control btn btn-primary" type="submit"></td>
          </tr>
        </table>
      </form>
    </div>
  </div>
</div>

</body>
</html>
