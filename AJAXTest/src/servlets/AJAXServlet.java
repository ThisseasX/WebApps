package servlets;

import models.Candidate;
import sevices.CandidateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AJAXServlet", urlPatterns = "/servlet")
public class AJAXServlet extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String s = request.getParameter("q");
        try (PrintWriter out = response.getWriter()) {
            List<Candidate> list = CandidateService.getAllCandidates(s);

            out.println("<style>table, th, td {text-align: center;}</style>");

            out.println("<table class='table table-bordered table-hover'>");
            out.println("<tr>");
            out.println("<th>AFM</th>");
            out.println("<th>Name</th>");
            out.println("<th>Surname</th>");
            out.println("</tr>");

            for (Candidate c : list) {
                out.println("<tr>");
                out.println("<td>" + c.getId() + "</td>");
                out.println("<td>" + c.getName() + "</td>");
                out.println("<td>" + c.getSurname() + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
