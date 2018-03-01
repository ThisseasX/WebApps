package entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "votes", schema = "voteapp", catalog = "")
@IdClass(VotesEntityPK.class)
public class VotesEntity {
    private int vAfm;
    private int cAfm;
    private Timestamp date;
    private byte vote;

    @Id
    @Column(name = "v_afm")
    public int getvAfm() {
        return vAfm;
    }

    public void setvAfm(int vAfm) {
        this.vAfm = vAfm;
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
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "vote")
    public byte getVote() {
        return vote;
    }

    public void setVote(byte vote) {
        this.vote = vote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VotesEntity that = (VotesEntity) o;

        if (vAfm != that.vAfm) return false;
        if (cAfm != that.cAfm) return false;
        if (vote != that.vote) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vAfm;
        result = 31 * result + cAfm;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (int) vote;
        return result;
    }
}
