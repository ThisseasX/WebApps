package servlets;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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

@WebServlet(name = "DBServlet", urlPatterns = {"/DBServlet"})
public class DBServlet extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>DBServlet</title>");
            out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'>");
            out.println("</head>");
            out.println("<body>");

            out.println("<div class='container my-3 indigo'>");

            try {
                Context initContext = new InitialContext();
                Context envContext = (Context) initContext.lookup("java:/comp/env");
                DataSource ds = (DataSource) envContext.lookup("jdbc/EpicDB");
                Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM superview");
                ResultSet rs = ps.executeQuery();
                int columnCount = rs.getMetaData().getColumnCount();

                out.println("<h1 id='test1' class='jumbotron'>" + conn.getCatalog() + " DB</h1>");
                out.println("<table class='table table-striped table-hover'");

                out.println("<tr>");
                for (int i = 1; i <= columnCount; i++)
                    out.println("<th>" + rs.getMetaData().getColumnName(i) + "</th>");
                out.println("</tr>");

                while (rs.next()) {
                    out.println("<tr>");
                    for (int i = 1; i <= columnCount; i++)
                        out.println("<td>" + rs.getString(i) + "</td>");
                    out.println("</tr>");
                }

                out.println("</table>");
                out.println("</div>");

                out.println("</body>");
                out.println("</html>");

            } catch (SQLException | NamingException e) {
                e.printStackTrace();
            }
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
