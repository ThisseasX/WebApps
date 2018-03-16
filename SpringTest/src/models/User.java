package models;

import javax.validation.constraints.Size;

public class User {

    @Size(message = "Your Username must not exceed {max} characters!", max = 10)
    private String username;
    @Size(message = "Your Password must not exceed {max} characters!", max = 10)
    private String password;

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
}
