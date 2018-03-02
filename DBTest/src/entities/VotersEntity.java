package entities;

import javax.persistence.*;

@Entity
@Table(name = "voters", schema = "voteapp")
public class VotersEntity {

    private int vAfm;
    private String vName;
    private String vSurname;
    private String vPassword;

    public VotersEntity() {
    }

    public VotersEntity(int vAfm, String vName, String vSurname, String vPassword) {
        this.vAfm = vAfm;
        this.vName = vName;
        this.vSurname = vSurname;
        this.vPassword = vPassword;
    }

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

        return vAfm == that.vAfm &&
                (vName != null ? vName.equals(that.vName) : that.vName == null) &&
                (vSurname != null ? vSurname.equals(that.vSurname) : that.vSurname == null) &&
                (vPassword != null ? vPassword.equals(that.vPassword) : that.vPassword == null);
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
