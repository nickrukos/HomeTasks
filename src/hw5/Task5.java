package hw5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task5
{
    public static void main(String[] args)
    {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("введите размер массива:");
        int N = sc.nextInt();
        int [] arr = new int[N];
        for (int i = 0; i < arr.length; i++)
             arr[i] = r.nextInt();
        int min_arr = Arrays.stream(arr).min().getAsInt();
        int max_arr = Arrays.stream(arr).max().getAsInt();
        double med_arr = 0.0;
        for (int x: arr)
             med_arr += x;
        med_arr /= arr.length;
        System.out.println("Элементы массива:");
        System.out.println(Arrays.toString(arr));
        System.out.println("Максимальный элемент массива: "  + max_arr);
        System.out.println("Минимальный элемент массива: "  + min_arr);
        System.out.println("Среднее арифметическое элементов массива: "  + med_arr);
    }

}
