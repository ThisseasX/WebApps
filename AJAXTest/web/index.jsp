<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: thiss
  Date: 6/3/2018
  Time: 9:30 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>AJAXTest</title>
  <link rel="stylesheet" href="css/bootstrap.css"/>
  <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
</head>
<body>

<div class="container">

  <h1 class="jumbotron text-center">Candidate Finder</h1>

  <div class="row">
    <div class="col-md-4 col-md-offset-4">
      <input class="form-control" id="cname"
             name="cname" title="cname" onkeyup="ajaxSend(this.value)">
    </div>
  </div>

  <div id="results" class="col-md-4 col-md-offset-4 text-center" style="margin-top: 20px">
    Candidate surnames will be displayed here.
  </div>

</div>

<script>

    function ajaxSend(v) {
        let results = $("#results");

        if (v.length === 0) {
            results.html("Candidate surnames will be displayed here.");
        } else {
            let xmlHttp = new XMLHttpRequest();
            xmlHttp.onreadystatechange = () => {
                if (xmlHttp.readyState === 4 && xmlHttp.status === 200) {
                    results.html(xmlHttp.responseText);
                }
            };
            xmlHttp.open("GET", "/table.jsp?q=" + v, true);
            xmlHttp.send();
        }
    }

</script>

</body>
</html>
