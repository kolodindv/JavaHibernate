package Entities;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    @Column(name = "login")
    private String login;
    @Column(name = "passwordHashCode")
    private int passwordHashCode;

    public User() {}

    public User(String login, int passwordHashCode) {
        this.login = login;
        this.passwordHashCode = passwordHashCode;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPasswordHashCode() {
        return passwordHashCode;
    }

    public void setPasswordHashCode(int passwordHashCode) {
        this.passwordHashCode = passwordHashCode;
    }
}

