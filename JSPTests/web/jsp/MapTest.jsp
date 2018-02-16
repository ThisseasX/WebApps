<%@page import="java.util.Map.Entry" %>
<%@page import="java.util.Map" %>
<%@page import="java.util.HashMap" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>MapTest</title>
</head>
<body>
<table border="2px">
    <tr>
        <th>Username</th>
        <th>Password</th>
    </tr>
    <%
        Map<String, String> users = new HashMap<>();
        users.put("Thiss", "123");
        users.put("Kwn", "234");
        users.put("Dimou", "345");
        users.put("Ntinos", "456");
        users.put("Olga", "567");

        for (Entry<String, String> entry : users.entrySet()) {
    %>
    <tr>
        <td><%=entry.getKey()%>
        </td>
        <td><%=entry.getValue()%>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
