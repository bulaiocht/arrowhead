package HomeTasks.pizzeria.classes.DataLoader;

import HomeTasks.pizzeria.classes.objects.Pizza;
import HomeTasks.pizzeria.type.PizzaType;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PropertiesLoader implements IMenu {

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

    @Override
    public List<Pizza> getPizzas() {

        List<Properties> propertiesOfPizzas = PropertiesLoader.loadPizzasProperties();
        List<Pizza> pizzasForMenu = new ArrayList<>();

        for (Properties property : propertiesOfPizzas) {

            pizzasForMenu.add(new Pizza(
                    Integer.parseInt(property.getProperty("id")),
                    Float.parseFloat(property.getProperty("price")),
                    Float.parseFloat(property.getProperty("timeOfCooking")),
                    PizzaType.valueOf(property.getProperty("type")),
                    property.getProperty("name")));
        }

        return pizzasForMenu;
    }

    private static List<Properties> loadPizzasProperties() {

        List<Properties> propertiesOfPizzas = new ArrayList<>();

        Properties pizza1 = PropertiesLoader.loadProperties("C:\\Users\\Женя\\IdeaProjects\\arrowhead\\yevhen-khominich\\src\\main\\resources\\pizza2.properties");
        Properties pizza2 = PropertiesLoader.loadProperties("C:\\Users\\Женя\\IdeaProjects\\arrowhead\\yevhen-khominich\\src\\main\\resources\\pizza1.properties");

        propertiesOfPizzas.add(pizza1);
        propertiesOfPizzas.add(pizza2);

        return propertiesOfPizzas;

    }
}







