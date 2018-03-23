package entities;

import javax.persistence.*;

@NamedQuery(name = "User.getAll", query = "SELECT u FROM User u")
@Entity
public class User {

    private int uid;
    private String username;
    private String password;
    private String name;
    private String surname;

    private Role role;

    public User() {
    }

    public User(int uid, String username, String password, String name, String surname, Role role) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

    @Id
    @Column(name = "uid", nullable = false)
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "username", nullable = false, length = -1)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = -1)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname", nullable = false, length = -1)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return uid == user.uid &&
                (username != null ? username.equals(user.username) : user.username == null) &&
                (password != null ? password.equals(user.password) : user.password == null) &&
                (name != null ? name.equals(user.name) : user.name == null) &&
                (surname != null ? surname.equals(user.surname) : user.surname == null);
    }

    @Override
    public int hashCode() {
        int result = uid;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "role", referencedColumnName = "rid", nullable = false)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
