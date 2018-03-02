package servlets;

import entities.CandidatesEntity;
import entities.VotersEntity;
import services.DBServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SuppressWarnings("unused")
@WebServlet(name = "DBServlet", urlPatterns = "/db")
public class DBServlet extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        int afm = Integer.parseInt(request.getParameter("afm"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String password = request.getParameter("password");

        DBServices.insertToDatabase(new VotersEntity(afm, name, surname, password));
        DBServices.insertToDatabase(new CandidatesEntity(afm, name, surname));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
