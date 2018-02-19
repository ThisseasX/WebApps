package servlets;

import services.VoterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "VoteServlet", urlPatterns = {"/vote"})
public class VoteServlet extends HttpServlet {

    @SuppressWarnings("unused")
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        String v_afm = request.getParameter("v_afm");
        String c_afm = request.getParameter("c_afm");
        int vote = Integer.parseInt(request.getParameter("vote"));

        if (VoterService.vote(v_afm, c_afm, vote)) {
            response.sendRedirect("jsp/vote.jsp");
        } else {
            response.sendRedirect("jsp/vote.jsp");
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
