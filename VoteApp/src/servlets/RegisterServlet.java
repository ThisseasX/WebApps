package servlets;

import models.Voter;
import services.VoterService;
import utils.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Voter v = new Voter(
                request.getParameter("register-afm"),
                StringUtils.capitalize(request.getParameter("name")),
                StringUtils.capitalize(request.getParameter("surname"))
        );

        boolean isRegisterSuccessful = VoterService.register(v, request.getParameter("register-password"));

        if (isRegisterSuccessful) {
            HttpSession session = request.getSession();
            session.setAttribute("voter", v);
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/vote.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("error", "Registration Failed");
            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
