<%@ page import="models.UserModel" %><%--
  Created by IntelliJ IDEA.
  User: thiss
  Date: 12/2/2018
  Time: 7:59 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RedirectTest</title>
</head>
<body>
<h1>
    RedirectJSP
</h1>
<p>
    Session Attribute: Name = <%= session.getAttribute("name")%>
</p>
<p>
    Request Parameter: Name = <%= request.getParameter("name")%>
</p>
<p>
    <%--Request Attribute: Age = <%= request.getAttribute("age")%>--%>
    Request Attribute: User:
</p>
<ul>
    <%
        UserModel user = (UserModel) request.getAttribute("user");
    %>
    <li>Username: <%=user.getName()%></li>
    <li>User Age: <%=user.getAge()%></li>
    <li>User ID: <%=user.getId()%></li>
</ul>
</body>
</html>
