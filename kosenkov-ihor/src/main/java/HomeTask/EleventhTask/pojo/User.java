package HomeTask.EleventhTask.pojo;

public class User {

    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String password;

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

    public static Builder newBuilder() {
        return new User().new Builder();
    }

    public class Builder{
        private Builder() {

        }

        public Builder setFirstName(String firstName) {
            User.this.firstName = firstName;

            return this;
        }
        public Builder setLastName(String lastName) {
            User.this.lastName = lastName;

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
