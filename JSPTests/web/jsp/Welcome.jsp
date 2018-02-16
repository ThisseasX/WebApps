<%--
  Created by IntelliJ IDEA.
  User: thiss
  Date: 13/2/2018
  Time: 4:13 πμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h1>
    Welcome <%=request.getParameter("username")%>!
</h1>

<h2>
    Your account balance is <%=request.getAttribute("amount")%>
</h2>
</body>
</html>
