package utils;

import models.Candidate;
import models.Voter;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CandidateUtils {

    public static List<Candidate> getAvailableCandidates(Voter v) {
        List<Candidate> list = new ArrayList<>();

        String sql = "SELECT c_afm, c_name, c_surname " +
                "FROM candidates " +
                "WHERE c_afm NOT IN " +
                "(SELECT candidates.c_afm " +
                "FROM candidates " +
                "INNER JOIN votes " +
                "ON candidates.c_afm = votes.c_afm " +
                "INNER JOIN voters " +
                "ON votes.v_afm = voters.v_afm " +
                "WHERE votes.v_afm = ?)";

        try (Connection con = DBUtils.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, v.getAfm());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Candidate c = new Candidate(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)
                );
                list.add(c);
            }

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static boolean vote(String v_afm, String c_afm, int vote) {
        String sql = "INSERT INTO votes VALUES(?,?,?,?);";

        try (Connection con = DBUtils.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String date = now.format(formatter);

            ps.setString(1, v_afm);
            ps.setString(2, c_afm);
            ps.setString(3, date);
            ps.setInt(4, vote);
            return ps.executeUpdate() > 0;

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return false;
    }
}
