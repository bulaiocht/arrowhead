package HomeTasks.pizzeria.classes.DataLoader;

import HomeTasks.pizzeria.classes.objects.Pizza;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonLoader implements IMenu{

    String json = "[{" +
            "    \"id\": \"1\"," +
            "    \"price\": \"85f\",\n" +
            "    \"timeOfCooking\": \"5f\"," +
            "    \"name\": \"Margarita\"," +
            "    \"type\": \"VEGETARIAN\"" +
            "}," +
            "{" +
            "    \"id\": \"2\"," +
            "    \"price\": \"95f\",\n" +
            "    \"timeOfCooking\": \"7f\"," +
            "    \"name\": \"Peperoni\"," +
            "    \"type\": \"MEAT\"" +
            "},"+
            "{" +
            "    \"id\": \"3\"," +
            "    \"price\": \"155f\",\n" +
            "    \"timeOfCooking\": \"8f\"," +
            "    \"name\": \"Tuna\"," +
            "    \"type\": \"MEAT\"" +
            "},"
            +
            "{" +
            "    \"id\": \"4\"," +
            "    \"price\": \"155f\",\n" +
            "    \"timeOfCooking\": \"9f\"," +
            "    \"name\": \"Five Cheeses\"," +
            "    \"type\": \"VEGETARIAN\"" +
            "},"+
            "{" +
            "    \"id\": \"5\"," +
            "    \"price\": \"130f\",\n" +
            "    \"timeOfCooking\": \"7f\"," +
            "    \"name\": \"With Bacon\"," +
            "    \"type\": \"MEAT\"" +
            "},"
            +
            "{" +
            "    \"id\": \"6\"," +
            "    \"price\": \"155f\",\n" +
            "    \"timeOfCooking\": \"9f\"," +
            "    \"name\": \"PapaJohn\"," +
            "    \"type\": \"MEAT\"" +
            "},"+
            "{" +
            "    \"id\": \"7\"," +
            "    \"price\": \"155f\",\n" +
            "    \"timeOfCooking\": \"7f\"," +
            "    \"name\": \"Carbonara\"," +
            "    \"type\": \"MEAT\"" +
            "}]";

    @Override
    public List<Pizza> getPizzas() {
        ObjectMapper mapper = new ObjectMapper();
        List<Pizza> pizzas = new ArrayList<>();
        try {
            pizzas= Arrays.asList(mapper.readValue(json, Pizza[].class));

        } catch (IOException e) {
            System.out.println(e);
        }
        return pizzas;
    }
}
