package controllers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entities.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;

@WebServlet(name = "Servlet", urlPatterns = "/test")
public class Servlet extends HttpServlet {

    @SuppressWarnings("unused")
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Test</title>");
            out.println("</head>");
            out.println("<body>");

            try {
                String json = readUrl("http://localhost:8080/RESTTest_war_exploded/api/users/all");
                Gson gson = new Gson();
                Type listType = new TypeToken<List<UserEntity>>() {
                }.getType();
                List<UserEntity> users = gson.fromJson(json, listType);

                out.println("<h1>Users:</h1>");
                for (UserEntity u : users) {
                    out.println("<p>");
                    out.println(u.getUsername());
                    out.println(u.getPassword());
                    out.println("</p>");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    @SuppressWarnings("SameParameterValue")
    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder buffer = new StringBuilder();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
