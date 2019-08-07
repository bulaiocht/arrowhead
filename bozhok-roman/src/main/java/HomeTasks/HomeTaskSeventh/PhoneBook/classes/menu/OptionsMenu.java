package HomeTasks.HomeTaskSeventh.PhoneBook.classes.menu;

import HomeTasks.HomeTaskSeventh.PhoneBook.classes.utils.Utils;

import java.util.Scanner;

public enum OptionsMenu {
    SAVEFILE (1,"SAVE FILE"){
        @Override
        public void options (){
            Utils.saveOnFile();
        }

    }
    ,ADDNEWCONTACT(2,"ADD NEW CONTACT"){
        @Override
        public void options (){
            System.out.println("ENTER NAME:");
            Scanner scanner = new Scanner(System.in);
            String s1 = scanner.nextLine();
            System.out.println("ENTER NUMBER:");
            String s2 = scanner.nextLine();
            Utils.addNewContact(s1,s2);

        }
    }
    ,SHOWCONTACT (3,"SHOW CONTACT"){
        @Override
        public void options(){
            Utils.showContact();
        }
    }
    ,REMOVESOMECONTACT(4,"REMOVE SOME CONTACT"){
        @Override
        public void options(){
            System.out.println("ENTER NAME:");
            Scanner scanner = new Scanner(System.in);
            String s1 = scanner.nextLine();
            System.out.println("ENTER NUMBER:");
            String s2 = scanner.nextLine();
            Utils.removeSomeContact(s1,s2);
        }
    }
    ,FINDSOMECONTACT(5,"FIND SOME CONTACT"){
        @Override
        public void options (){
            System.out.println("ENTER NAME:");
            Scanner scanner = new Scanner(System.in);
            String s1 = scanner.nextLine();
            Utils.findSomeContactForName(s1);

        }
    }
    ,SENDEMAIL(6,"SEND EMAIL"){
        @Override
        public void options (){
            System.out.println("ENTER EMAIL:");
            Scanner scanner = new Scanner(System.in);
            String s1 = scanner.nextLine();
            Utils.sendEmail(s1);

        }
    }
    ,EXIT(0,"EXIT"){
        @Override
        public void options(){
            int [] i = new int[1];
            i[10]=0;
        }
    };

    OptionsMenu(int option, String someOption) {
        this.option = option;
        this.someOption = someOption;
    }

    private   int option;
    private static final String SPLITTER = " - ";
    private  String someOption;

    public  int getOption() {
        return option;
    }

    public String getSomeOption() {
        return someOption;
    }
    public void options (){}

    @Override
    public String toString() {
        return option +SPLITTER+someOption;
    }
}
