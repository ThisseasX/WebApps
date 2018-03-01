<%--
  Created by IntelliJ IDEA.
  User: thiss
  Date: 1/3/2018
  Time: 8:53 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>FileUpload</title>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data">
  <input type="file" name="file" size="60">
  <input type="submit" name="Upload">
</form>

</body>
</html>
