<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CheckboxTest</title>
</head>
<body>
<h1>What are your favorite foods?</h1>
<form method="post" action="${pageContext.request.contextPath}/FoodServlet">
    <%
        List<String> list = new ArrayList<>(Arrays.asList(
                "Pasta",
                "Meat",
                "Fruit",
                "Vegetables",
                "Fish")
        );
        for (String s : list) {
    %>
    <label>
        <input name="<%=s%>" type="checkbox" value="<%=s%>"> <%=s%>
    </label>
    <br>
    <%
        }
    %>
    <br><br>
    <input type="submit">
</form>
</body>
</html>
