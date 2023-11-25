import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        List<Product> nameProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equals(nameInit)) {
                nameProducts.add(product);
                for (Product nameProduct : nameProducts) {
                    if (nameProduct.getStartDate().equals(targetDate)) {
                        System.out.println(nameProduct);
                    }
                }

            }
        }
    }
}
