package hw5;

import java.util.Arrays;
import java.util.Scanner;

public class Task8
{
    public static void main(String[] args)
    {
        int count = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите размер массива:");
        int N = sc.nextInt();
        int [] arr = new int[N];
        System.out.println("Заполните массив отрицательными и положительными числами:");
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = sc.nextInt();
            if (arr[i] < 0) count ++;
        }
        int[] arr_new = new int[count];
        int i =0;
        int j = 0;
        while (i < arr_new.length)
        {
            while (j < arr.length)
            {
                if (arr[j] < 0)
                {
                    arr_new[i] = arr[j];
                    i ++;
                }
                j++;
            }
        }
        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(arr));
        System.out.println("Новый массив:");
        System.out.println(Arrays.toString(arr_new));
    }
}
