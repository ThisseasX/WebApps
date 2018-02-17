package servlets;

import models.Voter;
import utils.DBUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>RegisterServlet</title>");
            out.println("</head>");
            out.println("<body>");

            Voter v = new Voter(
                    request.getParameter("register-afm"),
                    DBUtils.capitalize(request.getParameter("name")),
                    DBUtils.capitalize(request.getParameter("surname"))
            );

            boolean isRegisterSuccessful = v.register(request.getParameter("register-password"));

            if (isRegisterSuccessful) {
                HttpSession session = request.getSession();
                session.setAttribute("voter", v);
                RequestDispatcher rd = request.getRequestDispatcher("/jsp/LoginSuccess.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("error", "Registration Failed");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
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
