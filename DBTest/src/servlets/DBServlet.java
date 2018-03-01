package servlets;

import services.CandidateServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DBServlet", urlPatterns = "/db")
public class DBServlet extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        int afm = Integer.parseInt(request.getParameter("c_afm"));
        String name = request.getParameter("c_name");
        String surname = request.getParameter("c_surname");

        CandidateServices.insertCandidate(afm, name, surname);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
