package HomeTasks.HomeTaskEleventh.dao;


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

        public Builder setAge (int age){
            User.this.age = age;
            return this;
        }
        public Builder setEmail(String email) {
            User.this.email= email;
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
