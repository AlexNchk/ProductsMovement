import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            List<Product> products = GsonOperations.loadProducts();//загружаем список из файла
            System.out.println("Выбери действие или введи end:");
            System.out.println("1. Дать новое изделие в работу");
            System.out.println("2. Смотреть изделие по названию");
            System.out.println("3. Смотреть изделие по дате введения в работу");
            System.out.println("4. Смотреть изделие по дате покраски");
            System.out.println("5. Смотреть список полностью");
            System.out.println("6. Редактировать");
            String inputEnd = scanner.nextLine();
            if (inputEnd.equals("end")) {
                break;
            }
            int input = Integer.parseInt(inputEnd);
            switch (input) {
                case 1:
                    System.out.println("Введи название в формате <Название-размер>. Пример: Антик-55");
                    String name = scanner.nextLine();
                    System.out.println("Введи количество");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    System.out.println("Введи дату в работу в формате ГГГГ-ММ-ДД");
                    LocalDate startDate = LocalDate.parse(scanner.nextLine());
                    System.out.println("Укажи дату покраски в формате ГГГГ-ММ-ДД");
                    LocalDate endDate = LocalDate.parse(scanner.nextLine());
                    Product product = new Product(name, quantity, startDate, endDate);
                    products.add(product);
                    GsonOperations.saveProduct(products);
                    System.out.println("Изделие " + product.getName() + " добавлено в работу");
                    break;
                case 2:
                    System.out.print("Введи название");
                    String nameInit = scanner.nextLine();
                    PrintOperations.namesPrint(products, nameInit);
                    break;
                case 3:
                    System.out.println("Введи дату введения в работу в формате ГГГГ-ММ-ДД. Пример 2023-11-23");
                    LocalDate startDateInit = LocalDate.parse(scanner.nextLine());
                    PrintOperations.datePrintStart(products, startDateInit);
                case 4:
                    System.out.println("Введи дату покраски в формате ГГГГ-ММ-ДД. Пример 2023-11-23");
                    LocalDate endDateInit = LocalDate.parse(scanner.nextLine());
                    PrintOperations.datePrintEnd(products, endDateInit);
                case 5:
                    PrintOperations.allNamesPrint(products);
                    break;
                case 6:
                    System.out.println("Вы в секретном отделе :-)");//шутка, хочу добавить опцию редактирования
                    System.out.print("Введи название");
                    String nameSearch = scanner.nextLine();
                    PrintOperations.namesPrint(products, nameSearch);
                    System.out.println("Введи дату введения в работу в формате ГГГГ-ММ-ДД. Пример 2023-11-23");
                    LocalDate startDateSearch = LocalDate.parse(scanner.nextLine());
                    PrintOperations.namesAndDatePrint(products, nameSearch, startDateSearch);
                    //сюда добавим функцию удаления, пока не добрался, так  что вводим данные внимательно )))
                    break;


                default:
                    System.out.println("Нет такой опции");
            }
        }
    }
}
