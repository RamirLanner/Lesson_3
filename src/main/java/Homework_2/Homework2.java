package Homework_2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Homework2 {

    private static char[] secretWord; //буду использовать глобальную переменную, хочу кумулятивно наполнять подсказку
    //по задаче не понятно подсказка должна дополнятся или затираться при следующем вводе
    //облегчим задачу игроку и будем дополнять)

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        secretWord = new char[]{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}; //'X' не удобно в консоли смотреть что угадал, переделал на тире

        Random random = new Random();
        String randomWord = words[random.nextInt(words.length)];
        Scanner scanner = new Scanner(System.in);

        //System.out.println(randomWord);
        System.out.println("Давай сыграем в угадай слово!");
        System.out.println("какое из следующих слов я тебе загадал:");
        System.out.println(Arrays.toString(words));
        System.out.println("Напиши его, буду давать подсказки, приступим!");

        String inputString;
        while (!randomWord.equals(inputString = scanner.next())) { //проверка на совпадение
            System.out.println("Не угадал, попробуй еще. Посмотри ниже совпали ли буквы.");
            System.out.println(printHelp(inputString, randomWord));//метод - вывод подсказки
        }

        System.out.println("Вы угадали");
    }

    private static String printHelp (String inputString, String randomWord){
        //тут определяем что короче, введеное слово или загаданное, чтобы не обраится к несуществующему элементу строки
        int myCount = Math.min(inputString.length(), randomWord.length());
        StringBuilder myStr = new StringBuilder();// для удобства вывода
        for (int i =0; i < myCount; i++){
            if(inputString.charAt(i)==randomWord.charAt(i)){
                // это для отображения подсказки
                secretWord[i] = inputString.charAt(i);
            }
        }
//        for (char myChar: secretWord){
//            myStr.append(myChar);
//        }
//        return myStr.toString();
        return String.valueOf(secretWord);
    }


}
