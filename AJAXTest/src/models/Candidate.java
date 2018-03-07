package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "candidates", schema = "voteapp")
@NamedQuery(name = Candidate.GET_ALL, query = "SELECT c FROM Candidate c WHERE surname LIKE :s")
public class Candidate implements Serializable {

    public static final String GET_ALL = "getAll";

    @Id
    @Column(name = "c_afm")
    private int id;

    @Column(name = "c_name")
    private String name;

    @Column(name = "c_surname")
    private String surname;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
