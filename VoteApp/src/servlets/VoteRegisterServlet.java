package servlets;

import models.VoterModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "VoteRegisterServlet", urlPatterns = {"/VoteRegisterServlet"})
public class VoteRegisterServlet extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>VoteRegisterServlet</title>");
            out.println("</head>");
            out.println("<body>");

            VoterModel vm = new VoterModel(
                    request.getParameter("rafm"),
                    request.getParameter("name"),
                    request.getParameter("surname")
            );

            boolean isRegisterSuccessful = vm.register(request.getParameter("rpassword"));

            if (isRegisterSuccessful) {
                RequestDispatcher rd = request.getRequestDispatcher("/jsp/RegisterSuccess.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("error", "Registration Failed");
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
