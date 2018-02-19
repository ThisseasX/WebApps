package services;

import models.Candidate;
import models.Voter;
import utils.DBUtils;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class VoterService {

    public static boolean canVote(String afm) {
        String sql = "SELECT count(*) FROM votes WHERE v_afm = ?";

        try (Connection con = DBUtils.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, afm);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) < 3;
            }

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean vote(String v_afm, String c_afm, int vote) {
        if (canVote(v_afm)) {
            String sql = "INSERT INTO votes VALUES(?,?,?,?)";

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
        }
        return false;
    }

    public static List<Candidate> getVoteHistory(Voter v) {
        //language=MySQL
        String sql = "" +
                "SELECT " + CandidateService.SQL_CANDIDATE + ", vote " +
                "FROM candidates " +
                CandidateService.SQL_JOIN_VOTES + " " +
                "WHERE votes.v_afm = ?";

        return CandidateService.getCandidateList(v, sql);
    }
}
