<<<<<<< HEAD
package HomeTasks.phonebook.classes.service;
=======
package classes.service;
>>>>>>> yevhen-khominich

import classes.configs.PhoneBookConfig;

import java.io.*;
import java.util.HashMap;


public class PhoneBook {

    HashMap<String, String> contacts = new HashMap<>();

    // Сохранять новый контакт.
    public void saveContact(String name, String number) {
        contacts.put(name, number);
    }

    // Искать контакт по имени.
    public void findContact(String name) {

        if (contacts.get(name) != null)
            System.out.println("Number of contact : " + name + " is " + contacts.get(name) + "\n");
        else System.out.println("No such contact");
    }

    // Удалять контакт по имени
    public void removeContact(String name) {
        contacts.remove(name);
    }


    // Валидировать пользовательский ввод.


    // Экспортировать контакты в простой текстовый формат или в CSV (на выбор).
    public void exportToCsv() {
        saveToCsv();
    }

    // Уметь читать уже сохраненные контакты из простого текстового файла или из CSV при запуске.

    public void loadContacts() {

        File csvFile = new File(PhoneBookConfig.PATH_TO_FILE);

        if (csvFile.isFile()) {
            // create BufferedReader and read data from csv
            try {
                BufferedReader reader = new BufferedReader(new FileReader(PhoneBookConfig.PATH_TO_FILE));
                String row;

                while ((row = reader.readLine()) != null) {
                    if (row.contains("Number")) continue;
                    String[] data = row.split(",");
                    if (data.length == 2)
                        // do something with the data
                        contacts.put(data[0], data[1]);

                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void showExistContacts() {

        contacts
                .keySet()
                .stream()
                .forEach(name -> System.out.println(name + " " + contacts.get(name)));

    }

    private void saveToCsv() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(PhoneBookConfig.PATH_TO_FILE));

            writeHeader(writer);

            contacts
                    .keySet()
                    .forEach(name -> writeToCsv(writer, name));

            writer.flush();
            writer.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToCsv(BufferedWriter writer, String name) {
        try {
            writer.append(name);
            writer.append(",");
            writer.append(contacts.get(name));
            writer.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeHeader(BufferedWriter writer) {
        try {
            writer.append("Name");
            writer.append(",");
            writer.append("Number");
            writer.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
