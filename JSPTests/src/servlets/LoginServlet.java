package servlets;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<h1>LoginServlet</h1>");
            try {
                Context initContext = new InitialContext();
                Context envContext = (Context) initContext.lookup("java:/comp/env");
                DataSource ds = (DataSource) envContext.lookup("jdbc/AfdempDB");
                Connection conn = ds.getConnection();

                PreparedStatement ps = conn.prepareStatement("SELECT ID FROM afdemp_java_1.users WHERE username=? AND password=?");
                ps.setString(1, request.getParameter("username"));
                ps.setString(2, request.getParameter("password"));
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    RequestDispatcher rd = request.getRequestDispatcher("/jsp/Welcome.jsp");

                    String userId = rs.getString("id");
                    request.setAttribute("user_id", userId);

                    PreparedStatement ps1 = conn.prepareStatement("SELECT amount FROM afdemp_java_1.accounts WHERE user_id=?");
                    ps1.setString(1, rs.getString(1));

                    ResultSet rs1 = ps1.executeQuery();
                    if (rs1.next()) {
                        request.setAttribute("amount", rs1.getString(1));
                    }
                    rd.forward(request, response);
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("/jsp/LoginTest.jsp");
                    request.setAttribute("wrong", "true");
                    rd.forward(request, response);
                }

            } catch (SQLException | NamingException e) {
                e.printStackTrace();
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
