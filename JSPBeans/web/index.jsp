<%--
  Created by IntelliJ IDEA.
  User: thiss
  Date: 23/2/2018
  Time: 6:57 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>BeansTest</title>
</head>
<body>

<jsp:useBean id="person" class="beans.Person" scope="request">
  <jsp:setProperty name="person" property="name" value="Thisssss"/>
</jsp:useBean>

<jsp:forward page="/page2.jsp"/>

</body>
</html>
