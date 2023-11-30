package menu;

import lombok.NoArgsConstructor;

import java.util.InputMismatchException;
import java.util.Scanner;

@NoArgsConstructor
public class MainMenu {

    Scanner scanner = new Scanner(System.in);
    String userName;
    String passWord;

    public void start() {
        while (true) {
            String text = """
                    *** CHOOSE YOUR ROLE : ***
                    1- STUDENT
                    2- TEACHER
                    3- EMPLOYEE
                    4- EXIT
                    """;
            System.out.println(text);
            int input = input();
            switch (input) {
                case 1 -> {
                    login();
                    new StudentMenu(userName, passWord);
                }
                case 2 -> {
                    login();
                    new TeacherMenu(userName, passWord);
                }
                case 3 -> {
                    login();
                    new EmployeeMenu(userName, passWord);
                }
                case 4 -> System.exit(-1);
                default -> {
                    System.out.println("INVALID INPUT  !");
                    start();
                }
            }
        }
    }


    void login() {

        System.out.println("USERNAME : ");
        this.userName = scanner.next();
        System.out.println("PASSWORD : ");
        this.passWord = scanner.next();

    }

    public Integer input() {
        int input;
        while (true) {
            try {
                input = scanner.nextInt();
                scanner.nextLine();
                return input;
            } catch (InputMismatchException in) {
                scanner.nextLine();
                System.out.println("PLEASE ENTER VALID NUMBER !");
            }
        }
    }
}