package beans;

import entities.Role;
import entities.User;
import sessionbeans.UserEJB;
import utils.HashingUtils;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean
@SessionScoped
public class UserBean {

    private String id;
    private String username;
    private String password;
    private String passwordConfirm;
    private String name;
    private String surname;

    private Role selectedRole;

    @EJB
    private UserEJB userEJB;

//    @PostConstruct
//    public void init() {
//        availableRoles = userEJB.fetchAllRoles();
//        users = userEJB.fetchAllUsers();
//    }

    public List<Role> fetchAllRoles() {
        return userEJB.fetchAllRoles();
    }

    public List<User> fetchAllUsers() {
        return userEJB.fetchAllUsers();
    }

    public String register() {
        if (password.equals(passwordConfirm)) {
            User u = new User(
                    Integer.parseInt(id),
                    username,
                    HashingUtils.hashPass(password),
                    name,
                    surname,
                    selectedRole
            );
            try {
                userEJB.register(u);
            } catch (EJBTransactionRolledbackException e) {
                e.printStackTrace();
                return "index";
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Passwords don't match!"));
            return "index";
        }
        return "users";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Role getSelectedRole() {
        return selectedRole;
    }

    public void setSelectedRole(Role selectedRole) {
        this.selectedRole = selectedRole;
    }
}
