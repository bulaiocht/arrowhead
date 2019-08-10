package lambdas;

public class Human {

    private String name;
    private String surname;
    private int friendsAmmount;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public int getFriendsAmmount() {
        return friendsAmmount;
    }

    public void setFriendsAmmount(final int friendsAmmount) {
        this.friendsAmmount = friendsAmmount;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", friendsAmmount=" + friendsAmmount +
                '}';
    }
}
