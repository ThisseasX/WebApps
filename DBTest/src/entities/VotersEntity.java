package entities;

import javax.persistence.*;

@Entity
@Table(name = "voters", schema = "voteapp", catalog = "")
public class VotersEntity {
    private int vAfm;
    private String vName;
    private String vSurname;
    private String vPassword;

    @Id
    @Column(name = "v_afm")
    public int getvAfm() {
        return vAfm;
    }

    public void setvAfm(int vAfm) {
        this.vAfm = vAfm;
    }

    @Basic
    @Column(name = "v_name")
    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    @Basic
    @Column(name = "v_surname")
    public String getvSurname() {
        return vSurname;
    }

    public void setvSurname(String vSurname) {
        this.vSurname = vSurname;
    }

    @Basic
    @Column(name = "v_password")
    public String getvPassword() {
        return vPassword;
    }

    public void setvPassword(String vPassword) {
        this.vPassword = vPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VotersEntity that = (VotersEntity) o;

        if (vAfm != that.vAfm) return false;
        if (vName != null ? !vName.equals(that.vName) : that.vName != null) return false;
        if (vSurname != null ? !vSurname.equals(that.vSurname) : that.vSurname != null) return false;
        if (vPassword != null ? !vPassword.equals(that.vPassword) : that.vPassword != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vAfm;
        result = 31 * result + (vName != null ? vName.hashCode() : 0);
        result = 31 * result + (vSurname != null ? vSurname.hashCode() : 0);
        result = 31 * result + (vPassword != null ? vPassword.hashCode() : 0);
        return result;
    }
}
