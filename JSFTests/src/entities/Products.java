package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Products {

    private int pid;
    private String name;

    @Id
    @Column(name = "pid")
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Products products = (Products) o;

        return pid == products.pid &&
                (name != null ? name.equals(products.name) : products.name == null);
    }

    @Override
    public int hashCode() {
        int result = pid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
