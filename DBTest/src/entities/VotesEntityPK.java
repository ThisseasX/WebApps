package entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class VotesEntityPK implements Serializable {
    private int vAfm;
    private int cAfm;

    @Column(name = "v_afm")
    @Id
    public int getvAfm() {
        return vAfm;
    }

    public void setvAfm(int vAfm) {
        this.vAfm = vAfm;
    }

    @Column(name = "c_afm")
    @Id
    public int getcAfm() {
        return cAfm;
    }

    public void setcAfm(int cAfm) {
        this.cAfm = cAfm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VotesEntityPK that = (VotesEntityPK) o;

        if (vAfm != that.vAfm) return false;
        if (cAfm != that.cAfm) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vAfm;
        result = 31 * result + cAfm;
        return result;
    }
}
