package ClassTask.pictureApp.userLogin.dao;



public class User {
    private Long ID;
    private String username;
    private String password;

    public Long getID() {
        return ID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    private User(){};
    public static User.Builder newBuilder() {
        return new User().new Builder();
    }
    public class Builder{
        private Builder() {

        }
        public User.Builder setID (Long ID) {
            User.this.ID = ID;

            return this;
        }
        public User.Builder setUsername(String username) {
            User.this.username = username;

            return this;
        }
        public User.Builder setPassword(String password) {
            User.this.password = password;

            return this;
        }
        public User build() {
            return User.this;
        }
    }
}
