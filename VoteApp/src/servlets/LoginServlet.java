package servlets;

import models.Voter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Voter v = (Voter) request.getSession().getAttribute("voter");

        if (v == null) {
            v = new Voter(
                    request.getParameter("login-afm")
            );
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/vote.jsp");
            rd.forward(request, response);
            return;
        }

        boolean loginSuccessful = v.login(request.getParameter("login-password"));

        if (loginSuccessful) {
            HttpSession session = request.getSession();
            session.setAttribute("voter", v);
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/vote.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("error", "Login Failed");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
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
