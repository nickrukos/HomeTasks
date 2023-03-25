package hw5;

import java.util.Arrays;
import java.util.Scanner;

public class Task6
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("введите размер массива:");
        int N = sc.nextInt();
        String [] arr = new String[N];
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите слово, для выхода наберите \"exit\":");
        String str = "";
        boolean haveWords = false;
        int i=0;
        while (i < arr.length)
        {
            str = scn.nextLine().trim();
            if (str.equalsIgnoreCase("exit") == true) break;
            for (int j = 0; j < i; j++)
            {
                if (arr[j].equalsIgnoreCase(str) == true)
                {
                    System.out.println("Такое слово уже есть!");
                    haveWords = true;
                    break;
                }
            }
            if(haveWords == false)
            {
                arr[i] = str;
                i++;
            }
        }
        if(str.equalsIgnoreCase("exit") == false)
        {
            System.out.println("Массив заполнен:");
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("Хорошего дня!");
    }
}
