package servlets;

import models.UserModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RedirectServlet", urlPatterns = {"/RedirectServlet"})
public class RedirectServlet extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        RequestDispatcher rd = request.getRequestDispatcher("/jsp/RedirectTest.jsp");

        HttpSession session = request.getSession();
        session.setAttribute("name", "Thiss");

        UserModel user = new UserModel(
                "Thiss",
                25,
                123
        );
        request.setAttribute("user", user);
        rd.forward(request, response);
//        response.sendRedirect("jsp/RedirectTest.jsp");


        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>RedirectServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>This is the Redirect Servlet</h1>");
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
