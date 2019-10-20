package HomeTasks.HomeTaskEleventh.dao;


import HomeTasks.HomeTaskSeventh.PhoneBook.classes.email.Email;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private String firstName;
    private String secondName;
    private int age;
    private String email;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    private User(){};
    public static Builder newBuilder() {
        return new User().new Builder();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public class Builder{
        private Builder() {

        }

        public Builder setFirstName(String firstName) {
            User.this.firstName = firstName;

            return this;
        }
        public Builder setSecondName(String secondName) {
            User.this.secondName = secondName;

            return this;
        }
        public Builder setAge(String age) throws IllegalArgumentException{
            try {
                int i = Integer.parseInt(age);
                User.this.age = i;
            }catch (NumberFormatException e){
                throw new IllegalArgumentException("Invalid age");
            }


            return this;
        }
        public Builder setAge (int age){
            User.this.age = age;
            return this;
        }
        public Builder setEmail(String email) {
            Pattern pattern1 = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE);
            Matcher m1 = pattern1.matcher(email);
            boolean b = m1.find();
            try {
                if (m1.group().length()!=email.length())
                    throw new IllegalArgumentException("Invalid email");

                User.this.email = email;
            }catch (IllegalStateException e) {
                throw new IllegalArgumentException("Invalid email");
            }


            return this;
        }

        public Builder setPassword(String password) {
            User.this.password = password;

            return this;
        }

        public User build() {
            return User.this;
        }
    }
}
