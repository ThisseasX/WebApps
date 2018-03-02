package entities;

import javax.persistence.*;

@Entity
@Table(name = "candidates", schema = "voteapp")
public class CandidatesEntity {

    private int cAfm;
    private String cName;
    private String cSurname;

    public CandidatesEntity() {
    }

    public CandidatesEntity(int cAfm, String cName, String cSurname) {
        this.cAfm = cAfm;
        this.cName = cName;
        this.cSurname = cSurname;
    }

    @Id
    @Column(name = "c_afm")
    public int getcAfm() {
        return cAfm;
    }
    public void setcAfm(int cAfm) {
        this.cAfm = cAfm;
    }

    @Basic
    @Column(name = "c_name")
    public String getcName() {
        return cName;
    }
    public void setcName(String cName) {
        this.cName = cName;
    }

    @Basic
    @Column(name = "c_surname")
    public String getcSurname() {
        return cSurname;
    }
    public void setcSurname(String cSurname) {
        this.cSurname = cSurname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CandidatesEntity that = (CandidatesEntity) o;

        return cAfm == that.cAfm &&
                (cName != null ? cName.equals(that.cName) : that.cName == null) &&
                (cSurname != null ? cSurname.equals(that.cSurname) : that.cSurname == null);
    }

    @Override
    public int hashCode() {
        int result = cAfm;
        result = 31 * result + (cName != null ? cName.hashCode() : 0);
        result = 31 * result + (cSurname != null ? cSurname.hashCode() : 0);
        return result;
    }
}
