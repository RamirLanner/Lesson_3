package Homework_1;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Homework1 {

    public static void main(String[] args) throws IOException {

        Random random = new Random();

        System.out.println("Давай сыграем в игру угадай число!");
        System.out.println("Я загадаю число от 0 до 9, у тебя 3 попытки чтобы угадать)");
        System.out.println("Поехали!!!");
        int myTry = 3;
        do {
            int randomInt = random.nextInt(10);
            //System.out.println(randomInt);
            int inputValue;
            for (int i = 0; i < myTry; i++) {
                System.out.println("\nВведите число от 0 до 9:");
                inputValue = InputValue();
                if (inputValue > randomInt) {
                    System.out.println("Загаданное число меньше, осталось попыток " + (myTry - i - 1) + " ");
                } else if (inputValue < randomInt) {
                    System.out.println("Загаданное число больше, осталось попыток " + (myTry - i - 1) + " ");
                } else {
                    System.out.println("Вы угадали");
                    break;
                }
            }
        } while (!ExitGame());

    }
    private static boolean ExitGame(){
        for (;;){
            System.out.println("Игра закончена! Хотите повторить? 1 - Да, 0 - Нет");
            switch (InputValue()) {
                case 0 -> {
                    return true;
                }
                case 1 -> {
                    return false;
                }
                default -> {
                }
            }
        }
    }

    private static int InputValue() {
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Введите целое число!");
                scanner.nextLine();
            }
        }
    }
}
