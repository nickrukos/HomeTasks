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
        System.out.println("������� ������ �������:");
        int N = sc.nextInt();
        int [] arr = new int[N];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = r.nextInt();
        }
        int minArr = arr[0];
        int maxArr = arr[0];
        double medArr = 0.0;
        for (int x: arr)
        {
            if(x < minArr ) minArr = x;
            if(x > maxArr) maxArr = x;
            medArr += x;
        }
        medArr /= arr.length;
        System.out.println("�������� �������:");
        System.out.println(Arrays.toString(arr));
        System.out.println("������������ ������� �������: "  + maxArr);
        System.out.println("����������� ������� �������: "  + minArr);
        System.out.println("������� �������������� ��������� �������: "  + medArr);
    }

}
