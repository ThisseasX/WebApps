package models;

public class CandidateModel {

    private String afm;
    private String name;
    private String surname;

    public CandidateModel(String afm, String name, String surname) {
        this.afm = afm;
        this.name = name;
        this.surname = surname;
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
