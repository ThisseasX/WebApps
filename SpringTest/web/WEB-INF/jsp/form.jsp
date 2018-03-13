<%--
  Created by IntelliJ IDEA.
  User: thiss
  Date: 12/3/2018
  Time: 8:29 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form"
           prefix="form" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Form</title>
</head>
<body>

<form:form method="post" modelAttribute="user" action="login">

  <table>
    <tr>
      <td><form:label path="username">Name:</form:label></td>
      <td><form:input path="username"/></td>
      <td><form:errors path="username" cssClass="error"/></td>
    </tr>
    <tr>
      <td><form:label path="password">Password:</form:label></td>
      <td><form:password path="password"/></td>
      <td><form:errors path="password" cssClass="error"/></td>
    </tr>
    <tr>
      <td colspan="3"><input type="submit" value="Login"></td>
    </tr>
  </table>

</form:form>

</body>
</html>