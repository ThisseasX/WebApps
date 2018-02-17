<%@ page import="models.Candidate" %>
<%@ page import="models.Voter" %>
<%@ page import="utils.CandidateUtils" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: thiss
  Date: 13/2/2018
  Time: 9:39 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>VoteApp</title>
  <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
      crossorigin="anonymous"> -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
        integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
        crossorigin="anonymous">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
          integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
          crossorigin="anonymous"></script>
</head>

<body>
<%
  Voter v = (Voter) session.getAttribute("voter");
%>


<%
  List<Candidate> list = CandidateUtils.getAvailableCandidates(v);
%>

<div class="container">
  <div class="row">
    <h1 class="col-md-6 col-md-offset-3" style="margin-top: 30px; margin-bottom: 50px">Login Successful: Welcome <%=v.getName()%>!</h1>
  </div>
  <div class="row">
    <div class="col-md-12">

      <div class="table-responsive">
        <table id="mytable" class="table table-bordred table-striped table-hover">

          <thead>
          <tr>
            <th>AFM</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Vote</th>
          </tr>
          </thead>

          <tbody>
          <%
            for (int i = 0; i < list.size(); i++) {
              Candidate c = list.get(i);
          %>
          <tr id="row-<%=i%>">
            <td>
              <%=c.getAfm()%>
            </td>
            <td>
              <%=c.getName()%>
            </td>
            <td>
              <%=c.getSurname()%>
            </td>
            <td>
              <p data-placement="top" data-toggle="tooltip" title="vote">
                <button onclick="post('/VoteServlet',{v_afm: <%=v.getAfm()%>, c_afm: <%=c.getAfm()%>, vote: 1},'post')"
                        class="btn btn-primary" data-title="yes">
                  <span class="glyphicon glyphicon-thumbs-up"></span>
                </button>
                <button onclick="post('/VoteServlet',{v_afm: <%=v.getAfm()%>, c_afm: <%=c.getAfm()%>, vote: -1},'post')"
                        class="btn btn-danger" data-title="no">
                  <span class="glyphicon glyphicon-thumbs-down"></span>
                </button>
              </p>
            </td>
          </tr>
          <%
            }
          %>

          </tbody>
        </table>

        <div class="clearfix"></div>
      </div>

    </div>
  </div>
</div>

<%--<div class="modal fade" id="vote-yes" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">

      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
          <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
        </button>
        <h4 class="modal-title custom_align" id="heading-one">Positive Vote</h4>
      </div>

      <div class="modal-body">
        <div class="alert alert-danger">
          <span class="glyphicon glyphicon-warning-sign"></span> Are you sure you want to delete this Record?
        </div>
      </div>

      <div class="modal-footer ">
        <button type="button" class="btn btn-success">
          <span class="glyphicon glyphicon-ok-sign"></span> Yes
        </button>
        <button type="button" class="btn btn-default" data-dismiss="modal">
          <span class="glyphicon glyphicon-remove"></span> No
        </button>
      </div>
    </div>
    <!-- /.modal-content -->
  </div>
  <!-- /.modal-dialog -->
</div>

<div class="modal fade" id="vote-no" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">

      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
          <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
        </button>
        <h4 class="modal-title custom_align" id="heading-two">Delete this entry</h4>
      </div>

      <div class="modal-body">
        <div class="alert alert-danger">
          <span class="glyphicon glyphicon-warning-sign"></span> Are you sure you want to delete this Record?
        </div>
      </div>

      <div class="modal-footer ">
        <button type="button" class="btn btn-success">
          <span class="glyphicon glyphicon-ok-sign"></span> Yes
        </button>
        <button type="button" class="btn btn-default" data-dismiss="modal">
          <span class="glyphicon glyphicon-remove"></span> No
        </button>
      </div>
    </div>
    <!-- /.modal-content -->
  </div>
  <!-- /.modal-dialog -->
</div>--%>

<script>
    function post(path, params, method) {
        method = method || "post"; // Set method to post by default if not specified.

        // The rest of this code assumes you are not using a library.
        // It can be made less wordy if you use one.
        var form = document.createElement("form");
        form.setAttribute("method", method);
        form.setAttribute("action", path);

        for (var key in params) {
            if (params.hasOwnProperty(key)) {
                var hiddenField = document.createElement("input");
                hiddenField.setAttribute("type", "hidden");
                hiddenField.setAttribute("name", key);
                hiddenField.setAttribute("value", params[key]);

                form.appendChild(hiddenField);
            }
        }

        document.body.appendChild(form);
        form.submit();
    }
</script>

</body>

</html>
