package demo.data.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User implements Comparable<User> {
    private int id;
    private String username;
    private String email;
    private String about;

    @JsonIgnore
    private String password;


    public User() {
    }

    public User(int id, String password, String username, String email, String about) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.email = email;
        this.about = about;
    }

    @Override
    public int compareTo(User user) {
        return username.compareTo(user.username);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
