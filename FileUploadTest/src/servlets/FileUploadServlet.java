package servlets;

import utils.DBUtils;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "FileUploadServlet", urlPatterns = "/upload")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5
)
public class FileUploadServlet extends HttpServlet {

    private static final String UPLOAD_DIR = "uploads";
    private static final String UPLOAD_PATH = "C:\\my_uploads\\";

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        final Part filePart = request.getPart("file");
        final String fileName = filePart.getSubmittedFileName();

        String applicationPath = request.getServletContext().getRealPath("");
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
        System.out.println(uploadFilePath);

        String myFileName = UPLOAD_PATH + fileName;
        filePart.write(myFileName);

        File f = new File(myFileName);
        FileInputStream fis = new FileInputStream(f);

        String sql = "INSERT INTO file VALUES (?)";
        try (Connection con = DBUtils.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setBlob(1, fis);
            ps.executeUpdate();

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
