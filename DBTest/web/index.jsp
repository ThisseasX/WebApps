<%--
  Created by IntelliJ IDEA.
  User: thiss
  Date: 28/2/2018
  Time: 9:23 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
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
      background-color: #f1f1f1;
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

    label {
      margin-right: 10px;
    }

    [type="submit"] {
      margin-top: 20px;
    }

    h1 {
      font-weight: bold;
    }

  </style>
</head>
<body>


<div class="container">

  <div class="row">

    <div class="col-md-4 col-md-offset-4">

      <div class="panel panel-default">
        <div class="panel-header">
          <h1 class="text-center">Register Voter</h1>
        </div>
        <div class="panel-body">
          <form class="form-group" action="${pageContext.request.contextPath}/db" method="post">
            <table>
              <tr>
                <td><label for="afm">AFM</label></td>
                <td><input class="form-control" id="afm" name="afm"></td>
              </tr>
              <tr>
                <td><label for="name">Name</label></td>
                <td><input class="form-control" id="name" name="name"></td>
              </tr>
              <tr>
                <td><label for="surname">Surname</label></td>
                <td><input class="form-control" id="surname" name="surname"></td>
              </tr>
              <tr>
                <td><label for="password">Password</label></td>
                <td><input class="form-control" id="password" name="password"></td>
              </tr>
              <tr>
                <td></td>
                <td><input class="form-control btn btn-primary" type="submit" value="Submit"></td>
              </tr>
            </table>
          </form>
        </div>
        <%--end panel--%>
      </div>
      <%--end div--%>

    </div>
    <%--end row--%>
  </div>
  <%--end container--%>
</div>

</body>
</html>
