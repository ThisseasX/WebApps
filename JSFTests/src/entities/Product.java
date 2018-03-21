package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

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

        Product product = (Product) o;

        return pid == product.pid &&
                (name != null ? name.equals(product.name) : product.name == null);
    }

    @Override
    public int hashCode() {
        int result = pid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
