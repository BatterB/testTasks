package firstTask;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку:");
        String string = scanner.nextLine();
        int sum =0;
        for (char symbol : string.toCharArray()){
            if (Character.isDigit(symbol))
                sum+=symbol - '0';
        }
        System.out.println("Сумма цифр равна: "+sum);
    }
}
