package hw4;

import java.util.Scanner;

public class Task4
{
    public static void main(String[] args)
    {
        int userAnswer;
        int minValue = 2, maxValue = 100;
        int javaValue = (maxValue - minValue)/2 + 1;
        Scanner userValue = new Scanner(System.in);
        System.out.println("Загадайте целое число в диапазоне [2;100]");
        while (true)
        {

            System.out.println("Ваше число равно " + javaValue + "? 0- НЕТ, 1 - ДА");
            userAnswer = userValue.nextInt();
            if (userAnswer == 1) {
                System.out.println("Я угадала!!!");
                System.out.println("Ваше число равно " + javaValue);
                break;
            }
            System.out.println("Ваше число больше " + javaValue + "? 0- НЕТ, 1 - ДА");
            userAnswer = userValue.nextInt();
            if (userAnswer == 1) {
                minValue = javaValue + 1;
                javaValue = minValue + (maxValue - minValue) / 2;
            } else {
                maxValue = javaValue - 1;
                javaValue = minValue + (maxValue - minValue) / 2;
            }

        }
    }
}
