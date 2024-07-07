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
import java.util.Scanner;

public class GsonOperations {
    // Этот класс отвечает за загрузку и сохранение списка в json формате
    public static List<Product> loadProducts() throws InterruptedException, IOException {
        List<Product> products = new ArrayList<>();
        try (Reader reader = new FileReader("products.json")) {
            Gson gson = new GsonBuilder().create();
            Type productListType = new TypeToken<List<Product>>() {
            }.getType();
            products = gson.fromJson(reader, productListType);
        } catch (IOException e) {
            //e.printStackTrace();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Файл не найден... Создать новый? (Д/Н)");
            String inputNo = scanner.nextLine();
            if (inputNo.equals("N") || inputNo.equals("Н") ||
                    inputNo.equals("n") || inputNo.equals("н")) {
                System.out.println("Выход из программы...");
                Thread.sleep(300);
                System.exit(0);
            } else if (inputNo.equals("Y") || inputNo.equals("Д") ||
                    inputNo.equals("y") || inputNo.equals("д")) {
                System.out.println("Создаем новый файл...");
                Thread.sleep(300);
                FileWriter writer = new FileWriter("products.json");
            }
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
