import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonOperations {
    // Этот класс отвечает за загрузку и сохранение списка в json формате
    public static List<Product> loadProducts() {
        List<Product> products = new ArrayList<>();
        try (Reader reader = new FileReader("products.json")) {
            Gson gson = new GsonBuilder().create();
            Type productListType = new TypeToken<List<Product>>() {
            }.getType();
            products = gson.fromJson(reader, productListType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    public static void saveProduct(List<Product> products) {
        try (FileWriter writer = new FileWriter("products.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(products);
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
