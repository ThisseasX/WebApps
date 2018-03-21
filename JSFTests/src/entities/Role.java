package entities;

import javax.persistence.*;
import java.util.Collection;

@NamedQuery(name = Role.GET_ALL, query = "SELECT r FROM Role r")
@Entity
public class Role {

    public static final String GET_ALL = "getAll";

    private int rid;
    private String name;
    private Collection<User> usersByRole;

    @Id
    @Column(name = "rid", nullable = false)
    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    @Basic
    @Column(name = "name", nullable = false, length = -1)
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

        Role role = (Role) o;

        return rid == role.rid &&
                (name != null ? name.equals(role.name) : role.name == null);
    }

    @Override
    public int hashCode() {
        int result = rid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "role")
    public Collection<User> getUsersByRole() {
        return usersByRole;
    }

    public void setUsersByRole(Collection<User> usersByRole) {
        this.usersByRole = usersByRole;
    }
}
