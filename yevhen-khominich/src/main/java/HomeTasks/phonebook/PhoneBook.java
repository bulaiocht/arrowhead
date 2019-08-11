package HomeTasks.phonebook;

import java.io.*;
import java.util.HashMap;
import java.util.ResourceBundle;

public class PhoneBook {

    HashMap<String, String> contacts = new HashMap<>();

    static ResourceBundle bundle = ResourceBundle.getBundle("config");
    final static String CSV = bundle.getString("pathToCsv");

    //1. Сохранять новый контакт.
    public void saveContact(String name, String number) {
        this.contacts.put(name, number);
    }

    //2.Искать контакт по имени.
    public void findContact(String name) {

        if (contacts.get(name) != null)
            System.out.println("Number of contact : " + name + " is " + this.contacts.get(name) + "\n");
        else System.out.println("No such contact");
    }


    //   3. Валидировать пользовательский ввод.


    // 4. Экспортировать контакты в простой текстовый формат или в CSV (на выбор).
    public void exportToCsv() {
        saveToCsv();
    }

    // 5. Уметь читать уже сохраненные контакты из простого текстового файла или из CSV при запуске.

    public void loadContacts() {

        File csvFile = new File(CSV);

        if (csvFile.isFile()) {
            // create BufferedReader and read data from csv
            try {
                BufferedReader csvReader = new BufferedReader(new FileReader(CSV));
                String row;

                while ((row = csvReader.readLine()) != null) {
                    if (row.contains("Number")) continue;
                    String[] data = row.split(",");
                    if (data.length == 2)
                        // do something with the data
                        contacts.put(data[0], data[1]);

                }
                csvReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void showExistContacts() {
        for (String name : this.contacts.keySet()) {
            System.out.println(name + "," + this.contacts.get(name));
        }
        System.out.println();
    }

//    private static void saveToTxt(String name, String number) {
//
//        try (
//                BufferedWriter writer = new BufferedWriter(new FileWriter("src\\main\\resources\\file.csv", true))
//        ) {
//            writer.write(name + "," + number + "\n");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }

    private void saveToCsv() {
        try {
            BufferedWriter csvWriter = new BufferedWriter(new FileWriter(CSV));
            csvWriter.append("Name");
            csvWriter.append(",");
            csvWriter.append("Number");
            csvWriter.append("\n");

            for (String name : this.contacts.keySet()) {
                csvWriter.append(name);
                csvWriter.append(",");
                csvWriter.append(this.contacts.get(name));
                csvWriter.append("\n");
            }

            csvWriter.flush();
            csvWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
