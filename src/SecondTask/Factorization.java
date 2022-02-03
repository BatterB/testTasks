package SecondTask;

import java.util.ArrayList;
import java.util.Scanner;

public class Factorization {
    public static void main(String[] args) {
        ArrayList<Integer> dividers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int number=-1;
        while (number==-1) {
            try {
                System.out.println("Введите число: ");
                number = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Неверно введеный тип данных");
            }
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            while (number % i == 0) {
                dividers.add(i);
                number /= i;
            }
        }

        if (number != 1) {
            dividers.add(number);
        }
        System.out.println("Простые множетели: ");
        for(int num : dividers)
            System.out.print(num + " ");
    }
}
