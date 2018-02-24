<%--@elvariable id="list" type="java.util.List"--%>
<%--
  Created by IntelliJ IDEA.
  User: thiss
  Date: 23/2/2018
  Time: 8:53 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>BeanTest</title>
</head>
<body>

<jsp:useBean id="person" class="beans.Person" scope="request"/>

<p>My name is: ${person.name}</p>
<p>My dog is: ${person.dog.dogName}</p>

<p>My first list item is: ${list[0]}</p>
<p>My second list item is: ${list[1]}</p>
<p>My third list item is: ${list[2]}</p>

</body>
</html>
