<%--
  Created by IntelliJ IDEA.
  User: thiss
  Date: 11/3/2018
  Time: 10:35 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Users</title>
</head>
<body>

<c:choose>

  <c:when test="${result_list != null}">
    <table>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Surname</th>
      </tr>
      <c:forEach var="u" items="${result_list}">
        <tr>
          <td>${u.id}</td>
          <td>${u.name}</td>
          <td>${u.surname}</td>
        </tr>
      </c:forEach>
    </table>
  </c:when>

  <c:otherwise>
    <c:choose>

      <c:when test="${result != null}">
        <h1>Welcome user ${result.id}!</h1>
        <h1>Your name is: ${result.name}!</h1>
        <h1>and your surname is: ${result.surname}!</h1>
      </c:when>

      <c:otherwise>
        <h1>User Not Found</h1>
      </c:otherwise>

    </c:choose>
  </c:otherwise>

</c:choose>

</body>
</html>