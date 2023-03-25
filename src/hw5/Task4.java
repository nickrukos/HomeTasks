package hw5;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Task4
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("введите размер массива:");
        int N = sc.nextInt();
        int [] arr = new int[N];
        int temp;
        int minValue = 2, maxValue = 20;
        int randomValue;
        for (int i = 0; i < arr.length; i++)
        {
            randomValue = minValue + (int)(Math.random() * ((maxValue - minValue) + 1));
            while (randomValue % 2 != 0)
                randomValue = minValue + (int)(Math.random() * ((maxValue - minValue) + 1));
            arr[i] = randomValue;
        }
        System.out.println("Исходный массив");
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length-1; i++)
        {
            for (int j = i+1; j < arr.length; j++)
            {
                if (arr[i] < arr[j])
                {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("Отсортированный массив");
        System.out.println(Arrays.toString(arr));
    }
}
