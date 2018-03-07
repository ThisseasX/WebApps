package sevices;

import models.Candidate;
import utils.DBUtils;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CandidateService {

    public static List<Candidate> getAllCandidates(String s) {
        List<Candidate> list = new ArrayList<>();

        //language=MySQL
        String sql = "SELECT * FROM candidates WHERE c_surname LIKE ?";
        try (Connection con = DBUtils.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Candidate c = new Candidate();
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                c.setSurname(rs.getString(3));
                list.add(c);
            }

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static List<Candidate> getAllCandidateEntities(String s) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("VoteApp");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Candidate> query = em.createNamedQuery(Candidate.GET_ALL, Candidate.class);
        query.setParameter("s", s + "%");
        return query.getResultList();
    }
}
