package HomeTasks.HomeTaskSeventh.PhoneBook.classes.readerConfig;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Properties {
    private static final File PATHCONFIG = new File(String.format("bozhok-roman" +
                    "%ssrc" +
                    "%smain" +
                    "%sresources" +
                    "%sconfigurationPhoneBook" +
                    "%sPhoneBookConfig.properties",
            File.separator,
            File.separator,
            File.separator,
            File.separator,
            File.separator));
    private static final String[] S = returnConfig();
    public static final String REGEXNAME = S[0];
    public static final String REGEXNUMBER = S[1];
    public static final String REGEXEMAIL= S[2];
    public static final String PATHPHONEBOOK= S[3];


    private static String[] returnConfig (){
        String[] s = new String[4];
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATHCONFIG))){
                int i = 0;
                while (true){
                    String line = bufferedReader.readLine();
                    if (line == null)
                        break;
                    s[i] = line;
                    i++;

                }
        }catch (IOException e){
            e.printStackTrace();
        }

        return s;

    }
}
