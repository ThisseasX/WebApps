<%@ page import="models.Candidate" %>
<%@ page import="models.Voter" %>
<%@ page import="services.CandidateService" %>
<%@ page import="services.VoterService" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: thiss
  Date: 13/2/2018
  Time: 9:39 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>VoteApp - Vote</title>
  <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
      crossorigin="anonymous"> -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
        integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
        crossorigin="anonymous">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
          integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
          crossorigin="anonymous"></script>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css"/>
</head>

<body>
<%
  HttpSession httpSession = request.getSession(false);
  Voter v = (Voter) httpSession.getAttribute("voter");
%>


<%
  if (v == null) {
    response.sendRedirect("/index.jsp");
    return;
  }
  List<Candidate> list = CandidateService.getAvailableCandidates(v);
%>

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
        <li class="active">
          <a href="${pageContext.request.contextPath}/jsp/vote.jsp">Vote</a>
        </li>
        <li>
          <a href="${pageContext.request.contextPath}/jsp/history.jsp">My Votes</a>
        </li>
        <li>
          <a href="${pageContext.request.contextPath}/jsp/rankings.jsp">Rankings</a>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li>
          <p class="navbar-text">Hello <strong style="margin-left: 5px"><%=v.getName()%>
          </strong></p>
        </li>
        <li>
          <a href="${pageContext.request.contextPath}/logout">
            <b>Logout</b>
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
           style="background-color: rgba(0,0,0,0.5); margin-top: 20px; margin-bottom: 40px">
        <h1 style="margin: 10px">Nerd Elections 2018</h1>
      </div>
    </div>
  </div>

  <%
    if (list.size() > 0 && VoterService.canVote(v.getAfm())) {
  %>

  <div class="row">
    <div class="col-md-6 col-md-offset-3">
      <div class="inner-addon left-addon">
        <i class="glyphicon glyphicon-search"></i>
        <input type="text" id="myInput" class="form-control" title="search" onkeyup="myFilter()"
               placeholder="Filter by surname...">
      </div>
    </div>
  </div>

  <div class="row">
    <div class="col-md-6 col-md-offset-3">

      <div class="table-responsive">

        <table id="myTable" class="table table-bordered table-striped table-hover">

          <thead>
          <tr>
            <th class="one">AFM</th>
            <th class="two">Name</th>
            <th>Surname</th>
            <th>Vote</th>
          </tr>
          </thead>

          <tbody>
          <%
            for (int i = 0; i < list.size(); i++) {
              Candidate c = list.get(i);
          %>
          <tr id="row-<%=i%>">
            <td class="one">
              <%=c.getAfm()%>
            </td>
            <td class="two">
              <%=c.getName()%>
            </td>
            <td>
              <%=c.getSurname()%>
            </td>
            <td>
              <p data-placement="top" data-toggle="tooltip" title="vote">
                <button onclick="post('/vote',{v_afm: <%=v.getAfm()%>, c_afm: <%=c.getAfm()%>, vote: 1},'post')"
                        class="btn btn-primary" data-title="yes">
                  <span class="glyphicon glyphicon-thumbs-up"></span>
                </button>
                <button onclick="post('/vote',{v_afm: <%=v.getAfm()%>, c_afm: <%=c.getAfm()%>, vote: -1},'post')"
                        class="btn btn-danger" data-title="no">
                  <span class="glyphicon glyphicon-thumbs-down"></span>
                </button>
              </p>
            </td>
          </tr>
          <%
            }
          %>

          </tbody>
        </table>

        <%
        } else {
        %>
        <div class="container">
          <h1 class="text-center text-danger col-md-4 col-md-offset-4"
              style="background-color: rgba(0,0,0,0.5)">
            <strong>You've reached your voting limit!</strong>
          </h1>
        </div>
        <%
          }
        %>

        <div class="clearfix"></div>
      </div>

    </div>
  </div>
</div>

<script src="${pageContext.request.contextPath}/js/script.js"></script>

</body>

</html>
