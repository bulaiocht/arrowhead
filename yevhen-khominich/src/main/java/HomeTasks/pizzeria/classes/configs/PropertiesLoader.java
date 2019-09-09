package HomeTasks.pizzeria.classes.configs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PropertiesLoader {

    public static Properties loadProperties(String pathToProperties) {

        try {

            FileInputStream in = new FileInputStream(pathToProperties);
            Properties properties = new Properties();
            properties.load(in);
            return properties;

        } catch (IOException e) {
            return null;
        }
    }


    public static List<Properties> loadPizzasProperties() {

        List<Properties> propertiesOfPizzas = new ArrayList<>();

        Properties pizza1 = PropertiesLoader.loadProperties("C:\\Users\\Женя\\IdeaProjects\\arrowhead\\yevhen-khominich\\src\\main\\resources\\pizza2.properties");
        Properties pizza2 = PropertiesLoader.loadProperties("C:\\Users\\Женя\\IdeaProjects\\arrowhead\\yevhen-khominich\\src\\main\\resources\\pizza1.properties");

        propertiesOfPizzas.add(pizza1);
        propertiesOfPizzas.add(pizza2);

        return propertiesOfPizzas;

    }
}







