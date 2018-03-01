<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: thiss
  Date: 27/2/2018
  Time: 6:40 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>JSTLTests</title>
</head>
<body>

<%
  List<String> stringList = new ArrayList<>(Arrays.asList("One", "Two", "Three"));
  pageContext.setAttribute("stringList", stringList);
%>

<c:forEach var="str" items="${stringList}">
  <p>${str}</p>
</c:forEach>

<c:forEach var="i" begin="0" end="5">
  <p>i</p>
</c:forEach>

</body>
</html>
