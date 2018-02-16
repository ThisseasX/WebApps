<%@ page import="models.CandidateModel" %>
<%@ page import="models.VoterModel" %>
<%@ page import="utils.CandidateUtils" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: thiss
  Date: 13/2/2018
  Time: 9:39 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>LoginSuccess</title>
</head>
<body>
<h1>Login Successful: Welcome <%=((VoterModel) session.getAttribute("voter")).getName()%>!</h1>

<%
  List<CandidateModel> list = CandidateUtils.getAllCandidates();
  for (CandidateModel cm : list) {
%>
<p>
  <%=cm.getName() + " " + cm.getSurname()%>
</p>
<%
  }
%>

</body>
</html>
