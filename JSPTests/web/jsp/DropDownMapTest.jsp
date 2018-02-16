<%@page import="java.util.Map.Entry" %>
<%@page import="java.util.Map" %>
<%@page import="java.util.HashMap" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>DropDownMapTest</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container py-3">
    <h1 class="jumbotron">Drop-down Map Test</h1>
    <table class="container table-bordered table-hover table-striped col-md-6">
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
    <br><br>
    <form class="col-md-6 container px-0" method="post" action="${pageContext.request.contextPath}/UserServlet">
        <select class="form-control" name="item" multiple size="<%=users.size()%>" title="User">
            <%
                for (Entry<String, String> entry : users.entrySet()) {
            %>
            <option value="<%=String.valueOf(entry.getKey() + "_" + entry.getValue())%>"><%=entry.getKey()%>
            </option>
            <%
                }
            %>
        </select>
        <br><br>
        <input type="submit">
    </form>
</div>
</body>
</html>
