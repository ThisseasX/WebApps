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
  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
        integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

  <!-- Optional theme -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
        integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

  <!-- Latest compiled and minified JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
          integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
          crossorigin="anonymous"></script>
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

    input {
      margin: 2px;
    }

  </style>
</head>
<body>


<div class="container">

  <div class="row">

    <div class="col-md-4 col-md-offset-4">

      <div class="panel panel-default">
        <div class="panel-header">
          <h1 class="text-center">Register</h1>
        </div>
        <div class="panel-body">
          <form class="form-group" action="${pageContext.request.contextPath}/db" method="post">
            <table>
              <tr>
                <td><label for="c_afm">AFM</label></td>
                <td><input class="form-control" id="c_afm" name="c_afm"></td>
              </tr>
              <tr>
                <td><label for="c_name">Name</label></td>
                <td><input class="form-control" id="c_name" name="c_name"></td>
              </tr>
              <tr>
                <td><label for="c_surname">Surname</label></td>
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
  </div>
</div>

</body>
</html>
