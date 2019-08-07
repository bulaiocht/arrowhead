package HomeTasks.HomeTaskSeventh.PhoneBook.classes.menu;

import java.util.Scanner;

public class Menu {

    public static void starter (){
        OptionsMenu[] values = OptionsMenu.values();
        while (true){
            for (OptionsMenu value : values) {
                System.out.println(value);
            }
            try {
                System.out.println("ENTER OPTIONS:");
                Scanner scanner = new Scanner(System.in);
                int option = scanner.nextInt();
                for (OptionsMenu value : values) {
                    if (value.getOption()==option){
                        value.options();
                    }
                }

            }catch (IndexOutOfBoundsException e){
                break;
            }
        }
    }
}
