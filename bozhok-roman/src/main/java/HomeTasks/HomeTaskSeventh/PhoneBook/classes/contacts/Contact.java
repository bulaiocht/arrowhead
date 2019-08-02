package HomeTasks.HomeTaskSeventh.PhoneBook.classes.contacts;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {
    private String NAME ;
    private String NUMBER;

    public Contact(String NAME, String NUMBER) {
        Pattern pattern1 = Pattern.compile("([A-Z]{1}[a-zA-Z])\\w+");
        Pattern pattern2 = Pattern.compile("(\\+380[0-9]{9}$)");
        Matcher m1 = pattern1.matcher(NAME);
        Matcher m2 = pattern2.matcher(NUMBER);
        boolean b = m1.find();
        boolean b1 = m2.find();
        if (m1.group().length()!=NAME.length()) {
            throw new IllegalArgumentException("Invalid");
        }else if (m2.group().length()!=NUMBER.length()){
            throw new IllegalArgumentException("Invalid");}

        this.NAME = NAME;
        this.NUMBER = NUMBER;
    }

    public String getNAME() {
        return NAME;
    }

    public String getNUMBER() {
        return NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(NAME, contact.NAME) &&
                Objects.equals(NUMBER, contact.NUMBER);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NAME, NUMBER);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "NAME='" + NAME + '\'' +
                ", NUMBER='" + NUMBER + '\'' +
                '}';
    }
}
