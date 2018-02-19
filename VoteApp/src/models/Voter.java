package models;

import utils.DBUtils;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("unused")
public class Voter {

    private String afm;
    private String name;
    private String surname;

    public Voter(String afm, String name, String surname) {
        this.afm = afm;
        this.name = name;
        this.surname = surname;
    }

    public Voter(String afm) {
        this.afm = afm;
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
}
