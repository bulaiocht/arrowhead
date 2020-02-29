package HomeTasks.SimpleRegistration.entity;

import HomeTasks.SimpleRegistration.validation.Validation;

import java.sql.Date;

public class User {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int age;

    public User() {
    }

    public User(long id, String firstName, String lastName, String email, String password, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public User(String firstName, String lastName, String email, String password, int age) {

        if (!Validation.checkEmail(email)){
            throw new IllegalArgumentException("Incorrect email");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }
}
