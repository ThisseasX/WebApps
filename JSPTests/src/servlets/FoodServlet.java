package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FoodServlet", urlPatterns = {"/FoodServlet"})
public class FoodServlet extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FoodServlet</title>");
            out.println("</head>");
            out.println("<body>");
            Enumeration<String> names = request.getParameterNames();
            if (names != null && names.hasMoreElements()) {
                out.println("<h1>My Favorite Foods are:</h1>");
                out.println("<ul>");

                while (names.hasMoreElements()) {
                    String s = names.nextElement();
                    out.println("<li>" + s + "</li>");
                }
                out.println("<ul>");
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
