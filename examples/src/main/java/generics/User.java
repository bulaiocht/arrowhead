package generics;

import java.util.Objects;

public class User extends Person {

    String pass;
    String username;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        final User user = (User) o;
        return Objects.equals(pass, user.pass) &&
                Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pass, username);
    }
}
