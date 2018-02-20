<%--
  Created by IntelliJ IDEA.
  User: thiss
  Date: 13/2/2018
  Time: 3:51 πμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>VoteApp Login</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
        integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
        crossorigin="anonymous">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>

<body>


<nav class="navbar navbar-default navbar-inverse navbar-fixed-top" role="navigation">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
              data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="${pageContext.request.contextPath}/login">#NerdElections</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li>
          <a href="jsp/vote.jsp">Vote</a>
        </li>
        <li>
          <a href="jsp/history.jsp">My Votes</a>
        </li>
        <li>
          <a href="jsp/rankings.jsp">Rankings</a>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li>
          <p class="navbar-text">Already have an account?</p>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">
            <b>Login</b>
          </a>
        </li>
      </ul>
    </div>
    <!-- /.navbar-collapse -->
  </div>
  <!-- /.container-fluid -->
</nav>

<div class="container-fluid bg">

  <div class="row">
    <div class="jumbotron">
      <div class="container col-md-8 col-md-offset-2"
           style="background-color: rgba(0,0,0,0.5); margin-top: 20px;">
        <h1 style="margin: 10px">Nerd Elections 2018</h1>
      </div>
    </div>
  </div>

  <div class="row">
    <div class="panel panel-login col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3" style="margin-top: 50px">
      <div class="panel-heading">

        <div class="row">
          <div class="col-xs-6">
            <a href="#" class="active" id="login-form-link">Login</a>
          </div>

          <div class="col-xs-6">
            <a href="#" id="register-form-link">Register</a>
          </div>
        </div>
        <hr>
      </div>

      <div class="panel-body">
        <div class="row">
          <div class="col-lg-12">

            <form id="login-form" action="login" method="post" role="form" style="display: block;">

              <div class="form-group">
                <input pattern="[0-9]{1,15}" required type="number" name="login-afm" id="login-afm" tabindex="1"
                       class="form-control" placeholder="AFM">
              </div>

              <div class="form-group">
                <input pattern=".{1,30}" required type="password" name="login-password"
                       id="login-password"
                       tabindex="1"
                       class="form-control"
                       placeholder="Password">
              </div>

              <div class="form-group">
                <input type="submit" name="login-submit" id="login-submit" tabindex="4"
                       class="form-control btn btn-login"
                       value="Log In">
              </div>

            </form>

            <form id="register-form" action="register" method="post" role="form" style="display: none;">

              <div class="form-group">
                <input pattern="[0-9]{1,15}" required type="number" name="register-afm" id="register-afm" tabindex="1"
                       class="form-control"
                       placeholder="AFM">
              </div>

              <div class="form-group">
                <input pattern="[A-Za-z]{1,30}" required type="text" name="name" id="name" tabindex="2"
                       class="form-control" placeholder="Name">
              </div>

              <div class="form-group">
                <input pattern="[A-Za-z]{1,30}" required type="text" name="surname" id="surname" tabindex="2"
                       class="form-control"
                       placeholder="Surname">
              </div>

              <div class="form-group">
                <input pattern=".{1,30}" required type="password" name="register-password"
                       id="register-password" tabindex="3"
                       class="form-control"
                       placeholder="Password">
              </div>

              <div class="form-group">
                <input pattern=".{1,30}" type="password" name="confirm-password" id="confirm-password"
                       tabindex="3" class="form-control"
                       placeholder="Confirm Password">
              </div>

              <div class="form-group">
                <input type="submit" name="register-submit" id="register-submit" tabindex="4"
                       class="form-control btn btn-register" value="Register Now">
              </div>

            </form>
          </div>
        </div>
      </div>
    </div>
  </div>

  <%
    String error = (String) request.getAttribute("error");
    if (error != null) {
  %>
  <div id="error" class="row">
    <div class="container col-md-2 col-md-offset-5" style="background-color: rgba(0,0,0,0.5); margin-top: 0;">
      <h3 class="text-center" style="color: red">
        <strong>
          <%= error %>
        </strong>
      </h3>
    </div>
  </div>
  <%
    }
  %>

</div>
<script src="http://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/js/script.js"></script>
</body>

</html>