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
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>JSP Page</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
        integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
        crossorigin="anonymous">
  <style>
    .panel-login {
      border-color: #ccc;
      -webkit-box-shadow: 0px 2px 3px 0px rgba(0, 0, 0, 0.2);
      -moz-box-shadow: 0px 2px 3px 0px rgba(0, 0, 0, 0.2);
      box-shadow: 0px 2px 3px 0px rgba(0, 0, 0, 0.2);
    }

    .panel-login > .panel-heading {
      color: #00415d;
      background-color: #fff;
      border-color: #fff;
      text-align: center;
    }

    .panel-login > .panel-heading a {
      text-decoration: none;
      color: #666;
      font-weight: bold;
      font-size: 15px;
      -webkit-transition: all 0.1s linear;
      -moz-transition: all 0.1s linear;
      transition: all 0.1s linear;
    }

    .panel-login > .panel-heading a.active {
      color: #029f5b;
      font-size: 18px;
    }

    .panel-login > .panel-heading hr {
      margin-top: 10px;
      margin-bottom: 0px;
      clear: both;
      border: 0;
      height: 1px;
      background-image: -webkit-linear-gradient(left, rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.15), rgba(0, 0, 0, 0));
      background-image: -moz-linear-gradient(left, rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.15), rgba(0, 0, 0, 0));
      background-image: -ms-linear-gradient(left, rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.15), rgba(0, 0, 0, 0));
      background-image: -o-linear-gradient(left, rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.15), rgba(0, 0, 0, 0));
    }

    .panel-login input[type="text"],
    .panel-login input[type="email"],
    .panel-login input[type="password"] {
      height: 45px;
      border: 1px solid #ddd;
      font-size: 16px;
      -webkit-transition: all 0.1s linear;
      -moz-transition: all 0.1s linear;
      transition: all 0.1s linear;
    }

    .panel-login input:hover,
    .panel-login input:focus {
      outline: none;
      -webkit-box-shadow: none;
      -moz-box-shadow: none;
      box-shadow: none;
      border-color: #ccc;
    }

    .btn-login {
      background-color: #59B2E0;
      outline: none;
      color: #fff;
      font-size: 14px;
      height: auto;
      font-weight: normal;
      padding: 14px 0;
      text-transform: uppercase;
      border-color: #59B2E6;
    }

    .btn-login:hover,
    .btn-login:focus {
      color: #fff;
      background-color: #53A3CD;
      border-color: #53A3CD;
    }

    .btn-register {
      background-color: #1CB94E;
      outline: none;
      color: #fff;
      font-size: 14px;
      height: auto;
      font-weight: normal;
      padding: 14px 0;
      text-transform: uppercase;
      border-color: #1CB94A;
    }

    .btn-register:hover,
    .btn-register:focus {
      color: #fff;
      background-color: #1CA347;
      border-color: #1CA347;
    }
  </style>
</head>

<body>
<div class="container-fluid">
  <div class="jumbotron">
    <h1>Nerd Elections 2018</h1>
  </div>
  <div class="row">
    <div class="col-md-6 col-md-offset-3">
      <div class="panel panel-login">
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
              <form id="login-form" action="${pageContext.request.contextPath}/VoteLoginServlet" method="post"
                    role="form" style="display: block;">
                <div class="form-group">
                  <input required type="text" name="lafm" id="lafm" tabindex="1" class="form-control" placeholder="AFM">
                </div>
                <div class="form-group">
                  <input required type="password" name="lpassword" id="lpassword" tabindex="1" class="form-control"
                         placeholder="Password">
                </div>
                <div class="form-group">
                  <div class="row">
                    <div class="col-sm-6 col-sm-offset-3">
                      <input type="submit" name="login-submit" id="login-submit" tabindex="4"
                             class="form-control btn btn-login" value="Log In">
                    </div>
                  </div>
                </div>
              </form>
              <form id="register-form" action="${pageContext.request.contextPath}/VoteRegisterServlet" method="post"
                    role="form" style="display: none;">
                <div class="form-group">
                  <input required type="text" name="name" id="name" tabindex="1" class="form-control"
                         placeholder="Name">
                </div>
                <div class="form-group">
                  <input required type="text" name="surname" id="surname" tabindex="1" class="form-control"
                         placeholder="Surname">
                </div>
                <div class="form-group">
                  <input required type="password" name="rpassword" id="rpassword" tabindex="2" class="form-control"
                         placeholder="Password">
                </div>
                <div class="form-group">
                  <input type="password" name="cpassword" id="cpassword" tabindex="2" class="form-control"
                         placeholder="Confirm Password">
                </div>
                <div class="form-group">
                  <input required type="text" name="rafm" id="rafm" tabindex="2" class="form-control" placeholder="AFM">
                </div>
                <div class="form-group">
                  <div class="row">
                    <div class="col-sm-6 col-sm-offset-3">
                      <input type="submit" name="register-submit" id="register-submit" tabindex="4"
                             class="form-control btn btn-register" value="Register Now">
                    </div>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="http://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
<script>
    $(function () {
        $('#login-form-link').click(function (e) {
            $("#login-form").delay(100).fadeIn(100);
            $("#register-form").fadeOut(100);
            $('#register-form-link').removeClass('active');
            $(this).addClass('active');
            e.preventDefault();
        });
        $('#register-form-link').click(function (e) {
            $("#register-form").delay(100).fadeIn(100);
            $("#login-form").fadeOut(100);
            $('#login-form-link').removeClass('active');
            $(this).addClass('active');
            e.preventDefault();
        });

        var password = document.getElementById("rpassword");
        var confirm_password = document.getElementById("cpassword");

        function validatePassword() {
            if (password.value !== confirm_password.value) {
                confirm_password.setCustomValidity("Passwords don't match");
            } else {
                confirm_password.setCustomValidity('');
            }
        }

        password.onchange = validatePassword;
        confirm_password.onkeyup = validatePassword;
    });
</script>
</body>

</html>