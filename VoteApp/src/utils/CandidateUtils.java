package utils;

import models.CandidateModel;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CandidateUtils {

    public static List<CandidateModel> getAllCandidates() {
        List<CandidateModel> list = new ArrayList<>();

        String sql = "SELECT * FROM votes.candidates";

        try (Connection con = DBUtils.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CandidateModel cm = new CandidateModel(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)
                );
                list.add(cm);
            }

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return list;
    }
}
