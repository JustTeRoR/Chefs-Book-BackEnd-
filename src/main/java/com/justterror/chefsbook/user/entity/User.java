package com.justterror.chefsbook.user.entity;


import javax.annotation.security.DeclareRoles;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="username")
    @NotNull
    private String username;

    @Column(name="password")
    @NotNull
    private String password;

    @Column(name="role")
    @NotNull
    private String role;
    //TODO: Add tie this entity class with favourite meals for user

    public User() { }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
