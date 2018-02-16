package servlets;

import models.VoterModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "VoteLoginServlet", urlPatterns = {"/VoteLoginServlet"})
public class VoteLoginServlet extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>VoteLoginServlet</title>");
            out.println("</head>");
            out.println("<body>");

            VoterModel vm = new VoterModel(
                    request.getParameter("lafm")
            );

            boolean loginSuccessful = vm.login(request.getParameter("lpassword"));

            if (loginSuccessful) {
                HttpSession session = request.getSession();
                session.setAttribute("voter", vm);
                RequestDispatcher rd = request.getRequestDispatcher("/jsp/LoginSuccess.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("error", "Login Failed");
                RequestDispatcher rd = request.getRequestDispatcher("/jsp/index.jsp");
                rd.forward(request, response);
            }

            out.println("</body>");
            out.println("</html>");
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
