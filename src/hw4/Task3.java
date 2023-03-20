package hw4;

import java.util.Scanner;

public class Task3
{
    public static void main(String[] args)
    {
        Scanner userValue = new Scanner(System.in);
        int minValue = 1, maxValue = 9;
        int randomValue = minValue + (int)(Math.random() * ((maxValue - minValue) + 1));
        for (;;)
        {
            System.out.println("Введите целое число в диапазоне [1;9], или 0 для выхода");
            int userNumber = userValue.nextInt();
            if (userNumber == 0)
            {
                System.out.println("Спасибо за работу!");
                break;
            }
            if (randomValue == userNumber)
            {
                System.out.println("Вы угадали!!!");
                break;
            }
            if(userNumber > randomValue) System.out.println("Ваше число больше!");
            else System.out.println("Ваше число меньше!");
        }
    }
}
