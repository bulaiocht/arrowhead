package env;

public class EnvExample {

    private static final String USERNAME = "USER";
    private static final String PASSWORD = "PASS";

    public static void main(String[] args) {

        System.setProperty(USERNAME, "bob");
        System.setProperty(PASSWORD, "123");

        String username = System.getProperty(USERNAME);
        String password = System.getProperty(PASSWORD);

        System.out.printf("Logging in using username: \"%s\" and password: \"%s\"",
                username,
                password);

    }
}
