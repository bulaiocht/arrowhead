package HomeTasks.HomeTaskSeventh.PhoneBook.interfaces;

import HomeTasks.HomeTaskFifth.Path;

import java.io.File;

public interface PhoneBookPath {
    File FILE = new File(String.format("bozhok-roman%ssrc%smain%sresources%sphoneBook.csv",
            File.separator,
            File.separator,
            File.separator,
            File.separator));
}
