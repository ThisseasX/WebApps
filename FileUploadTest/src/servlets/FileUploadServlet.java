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
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SuppressWarnings({"unused", "ResultOfMethodCallIgnored"})
@WebServlet(name = "FileUploadServlet", urlPatterns = "/upload")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5
)
public class FileUploadServlet extends HttpServlet {

    private static final String UPLOAD_DIR = "c:\\uploads";

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        System.out.println("MY UPLOAD DIR IS: " + UPLOAD_DIR);

        final Part filePart = request.getPart("file");

        insertFileToDatabase(filePart);
        saveFileToDisk(filePart);
    }

    private void saveFileToDisk(Part filePart) {
        String fileName = filePart.getSubmittedFileName();

        File dir = new File(UPLOAD_DIR);
        File file = new File(dir, fileName);

        dir.mkdir();

        try (InputStream input = filePart.getInputStream()) {

            if (!file.exists()) {
                Files.copy(input, file.toPath());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void insertFileToDatabase(Part filePart) {
        String sql = "INSERT INTO file (file) VALUES (?)";

        try (InputStream input = filePart.getInputStream();
             Connection con = DBUtils.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setBlob(1, input);
            ps.executeUpdate();

        } catch (SQLException | NamingException | IOException e) {
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
