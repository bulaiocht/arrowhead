package HomeTasks.pizzeria.classes.DataLoader;

import HomeTasks.pizzeria.classes.objects.Pizza;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonLoader implements IMenu {

    final String PATH_TO_JSON = "yevhen-khominich\\src\\main\\resources\\menu.txt";
    final File JSON = new File(PATH_TO_JSON);

    @Override
    public List<Pizza> getPizzas() {

        ObjectMapper mapper = new ObjectMapper();
        List<Pizza> pizzas = new ArrayList<>();

        try {
            pizzas = Arrays.asList(mapper.readValue(JSON, Pizza[].class));

        } catch (IOException e) {
            System.out.println(e);
        }
        return pizzas;
    }
}
