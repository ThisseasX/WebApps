package models;

import javax.validation.constraints.Size;

public class User {

    @Size(message = "username.long", max = 10)
    private String username;
    @Size(message = "password.long", max = 10)
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
