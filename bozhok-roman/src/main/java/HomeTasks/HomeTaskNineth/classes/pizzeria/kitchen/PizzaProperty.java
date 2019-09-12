package HomeTasks.HomeTaskNineth.classes.pizzeria.kitchen;

import HomeTasks.HomeTaskNineth.classes.pizzeria.kitchen.Pizza;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PizzaProperty {
    private static final File FILE_MENU =
            new File(String.format("bozhok-roman" +
                    "%ssrc" +
                    "%smain" +
                    "%sresources" +
                    "%sconfigurationMenuPizza" +
                    "%spackage.json",
            File.separator,
            File.separator,
            File.separator,
            File.separator,
            File.separator));
    public static final List<Pizza> pizzas = getPizzas();


    private static List<Pizza> getPizzas (){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Pizza> pizzas = objectMapper.readValue(FILE_MENU,
                    new TypeReference<List<Pizza>>(){});
            return pizzas;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
