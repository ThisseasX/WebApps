package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyServlet", urlPatterns = {"/MyServlet"})
public class MyServlet extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>MyServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MyServlet at " + request.getProtocol() + "</h1>");
            out.println("<h1>I am " + name + "</h1>");
            out.println("<h1>I am " + age + " years old</h1>");
            for (String s : request.getParameterValues("item")) {
                String username = s.substring(0, s.indexOf("_"));
                String password = s.substring(s.indexOf("_") + 1);
                out.println("<h1>" + username + "'s password is " + password + "</h1>");
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
