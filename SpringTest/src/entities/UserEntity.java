package entities;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = UserEntity.GET_ALL, query = "SELECT u FROM UserEntity u"),
        @NamedQuery(name = UserEntity.GET_BY_ID, query = "SELECT u FROM UserEntity u WHERE id = :id")
})
@Entity
@Table(name = "user_test", schema = "dbtest")
public class UserEntity {

    public static final String GET_ALL = "getAll";
    public static final String GET_BY_ID = "getById";

    private int id;
    private String name;
    private String surname;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
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

        UserEntity that = (UserEntity) o;

        return id == that.id &&
                (name != null ? name.equals(that.name) : that.name == null) &&
                (surname != null ? surname.equals(that.surname) : that.surname == null);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }
}
