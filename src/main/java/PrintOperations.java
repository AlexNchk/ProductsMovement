import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class PrintOperations {
    public static void namesPrint(@NotNull List<Product> products, String nameInit) {
        for (Product product : products) {
            if (product.getName().equals(nameInit)) {
                System.out.println(product);
            }
        }
    }

    public static void datePrintStart(@NotNull List<Product> products, LocalDate targetDate) {
        for (Product product : products) {
            if (product.getStartDate().equals(targetDate)) {
                System.out.println(product);
            }
        }
    }

    public static void datePrintEnd(@NotNull List<Product> products, LocalDate targetDate) {
        for (Product product : products) {
            if (product.getEndDate().equals(targetDate)) {
                System.out.println(product);
            }
        }
    }

    public static void allNamesPrint(@NotNull List<Product> products) {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public static void namesAndDatePrint(@NotNull List<Product> products, String nameInit, LocalDate targetDate) {
        for (Product product : products) {
            if (product.getName().equals(nameInit) && product.getStartDate().equals(targetDate)) {
                System.out.println(product);
                System.out.println("Что вы хотите сделать?:");
                System.out.println("1. Изъять изделие из работы");
                System.out.println("2. Изменить количество изделий");
                System.out.println("3. Изменить дату введения в работу");
                int indexProduct = products.indexOf(product);
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 1:
                        products.remove(indexProduct);
                        GsonOperations.saveProduct(products);
                        System.out.println("Изделие изъято из работы!");
                        return;
                    case 2:
                        System.out.println("Введите количество");
                        String inputQuantity = scanner.nextLine();
                        int changeQuantity = Integer.parseInt(inputQuantity);
                        product.setQuantity(changeQuantity);
                        GsonOperations.saveProduct(products);
                        System.out.println("Количество " + product.getName() + " изменено на " + changeQuantity);
                        return;
                    case 3:
                        System.out.println("Введите дату в формате ГГГГ-ММ-ДД");
                        String inputDate = scanner.nextLine();
                        LocalDate changeDate = LocalDate.parse(inputDate);
                        product.setStartDate(changeDate);
                        GsonOperations.saveProduct(products);
                        System.out.println("Дата введения в работу изделия " + product.getName()
                                + " изменено на " + changeDate);
                        return;
                }
            }
        }
    }
}
