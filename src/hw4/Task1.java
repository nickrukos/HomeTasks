package hw4;

import java.util.Scanner;

public class Task1
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in); // объявлять до циклов
        System.out.println("Введите целое число: ");
        int userNumber = in.nextInt();
        int sum = 0;
        while(userNumber != 0)
        {
            sum += (userNumber % 10);
            userNumber/=10;
        }
        System.out.println("Сумма цифр Вашего числа равна " + sum);
    }
}
