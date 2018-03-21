package beans;

import entities.Role;
import entities.User;
import sessionbeans.RegisterEJB;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean
@SessionScoped
public class RegisterBean {

    private String id;
    private String username;
    private String password;
    private String passwordConfirm;
    private String name;
    private String surname;

    private Role selectedRole;

    private List<Role> availableRoles;

    @EJB
    private RegisterEJB registerEJB;

    @PostConstruct
    public void init() {
        availableRoles = registerEJB.fetchAllRoles();
    }

    public void register() {
        User u = new User(
                Integer.parseInt(id),
                username,
                password,
                name,
                surname,
                selectedRole
        );
        registerEJB.register(u);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RegisterEJB getRegisterEJB() {
        return registerEJB;
    }

    public void setRegisterEJB(RegisterEJB registerEJB) {
        this.registerEJB = registerEJB;
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

    public List<Role> getAvailableRoles() {
        return availableRoles;
    }

    public void setAvailableRoles(List<Role> availableRoles) {
        this.availableRoles = availableRoles;
    }
}
