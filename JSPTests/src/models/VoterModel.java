package models;

import utils.DBUtils;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VoterModel {

    private String afm;
    private String name;
    private String surname;
    private String password;

    public VoterModel(String afm, String name, String surname, String password) {
        this.afm = afm;
        this.name = name;
        this.surname = surname;
        this.password = password;
    }

    public VoterModel(String afm, String password) {
        this.afm = afm;
        this.password = password;
    }

    public String getAfm() {
        return afm;
    }

    public void setAfm(String afm) {
        this.afm = afm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean insertIntoDatabase() {
        String sql = "INSERT INTO votes.voters VALUES (?,?,?,?)";
        try (Connection con = DBUtils.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, afm);
            ps.setString(2, name);
            ps.setString(3, surname);
            ps.setString(4, password);
            return ps.executeUpdate() > 0;

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean login() {
        String sql = "SELECT vname, vsurname FROM votes.voters WHERE vafm=? AND vpassword=?";
        try (Connection con = DBUtils.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);) {

            ps.setString(1, afm);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                name = rs.getString(1);
                surname = rs.getString(2);
                return true;
            }

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return false;
    }
}
