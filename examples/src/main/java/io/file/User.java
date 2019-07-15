package io.file;


import java.io.Serializable;

class User implements Serializable, Cloneable {

    public static String field = "field";

    public static final long serialVersionUID = 2L;

    private String email;

    private transient String password;

    public User() {
    }

    public User(String username,
                String email,
                String password) {
        this.email = email;
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", field='" + field + '\'' +
                '}';
    }
}