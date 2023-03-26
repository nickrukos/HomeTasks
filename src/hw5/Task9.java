package hw5;

import java.util.Arrays;
import java.util.Scanner;

public class Task9
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
        int[] arrNew = new int[count];
        int i = 0;
        for (int x: arr)
        {
            if(x < 0)
            {
               arrNew[i] = x;
               i++;
            }
        }
        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(arr));
        System.out.println("Новый массив:");
        System.out.println(Arrays.toString(arrNew));
    }
}
