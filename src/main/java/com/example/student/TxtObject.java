package com.example.student;

/**
 * @Author Magixx
 * @Date 2023 04 17 16 00
 **/
public class TxtObject {

    private String firstname;
    private String lastname;
    private String username;
    private String password;

    public String getFirstname() {

        return firstname;

    }
    public void setFirstname(String firstname) {

        this.firstname = firstname;

    }
    public String getLastname() {

        return lastname;

    }
    public void setLastname(String lastname) {

        this.lastname = lastname;

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
    public TxtObject() {

        super();

    }

    @Override

    public String toString() {

        return "TxtObject [firstname=" + firstname + ", lastname=" + lastname + ", username="

                + username + ", password=" + password + "]";

    }

}