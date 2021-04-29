package net.toscalecz.test.entities;

import javax.persistence.*;
//tato entita je pro cteni a ukladani databazove tabulku user a zaroven ji vracim v rest api
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", unique = true, nullable = false)
    private String userName;
    @Column(name = "password", nullable = false)
    private String password;

    public User() {
    }

    public User(final String userName, final String password) {
        this.userName = userName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
}