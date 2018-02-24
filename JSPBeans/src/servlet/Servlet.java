package servlet;

import beans.Dog;
import beans.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "Servlet", urlPatterns = "/bean")
public class Servlet extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person p = new Person();
        p.setName("ThisseasX");

        Dog d = new Dog();
        d.setDogName("Spike");
        p.setDog(d);

        request.setAttribute("person", p);

        List<String> stringList = new ArrayList<>(Arrays.asList("One", "Two", "Three"));
        request.setAttribute("list", stringList);

        RequestDispatcher rd = request.getRequestDispatcher("/page2.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
