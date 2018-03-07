<%@ page import="models.Candidate" %>
<%@ page import="sevices.CandidateService" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: thiss
  Date: 7/3/2018
  Time: 3:58 πμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Test</title>

  <style>
    table, th, td {
      text-align: center;
    }
  </style>

</head>
<body>

<table class='table table-bordered table-hover'>
  <tr>
    <th>AFM</th>
    <th>Name</th>
    <th>Surname</th>
  </tr>

  <% List<Candidate> list = CandidateService.getAllCandidates(request.getParameter("q"));
    pageContext.setAttribute("list", list);
  %>

  <c:forEach var="c" items="${list}">
    <tr>
      <td>${c.id}</td>
      <td>${c.name}</td>
      <td>${c.surname}</td>
    </tr>
  </c:forEach>

</table>
</body>
</html>