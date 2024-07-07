import java.util.Scanner;

public class Authorization {
    static final String PASSWORD = "Test";
    public static void VerifyPassword() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int attempts = 4;
        String password = "";
        while (attempts-- > 0)
        {
            System.out.print("Введи свой пароль: ");
            password = sc.nextLine();
            if (password.equals(PASSWORD)) {
                System.out.println("Добро пожаловать!!!");
                break;
            }
            else if (attempts == 1){
                System.out.println("Выход из системы...");
                System.exit(0);
                Thread.sleep(600);
            }
            System.out.println("Неправильный пароль, попыток осталось: " + (attempts-1));
        }
    }
}
