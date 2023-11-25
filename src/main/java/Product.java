import java.time.LocalDate;

public class Product {
    private final String name;
    private final int quantity;
    private final LocalDate startDate;
    private final LocalDate endDate;

    /* В этом класее создаем объект имеющий следующие свойства
    Наименование, количество, дата в работу, дата покраски
    */
    public Product(String name, int quantity, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.quantity = quantity;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
// пока оставил на случай включения функции редактирования списка
//    public void setEndDate(LocalDate endDate) {
//        this.endDate = endDate;
//    }

    @Override
    public String toString() {
        return "Наименование: " + name +
                ", Количество: " + quantity +
                ", Дата в работу: " + startDate +
                ", Дата на покраску: " + endDate;
    }
}
