package hw5;

import java.util.Arrays;
import java.util.Scanner;

public class Task6
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("������� ������ �������:");
        int N = sc.nextInt();
        String [] arr = new String[N];
        Scanner scn = new Scanner(System.in);
        System.out.println("������� �����, ��� ������ �������� \"exit\":");
        String str = "";
        boolean haveWords = false;
        int i=0;
        while (i < arr.length)
        {
            str = scn.nextLine().trim();
            if (str.equalsIgnoreCase("exit")) break;
            for (int j = 0; j < i; j++)
            {
                if (arr[j].equalsIgnoreCase(str))
                {
                    System.out.println("����� ����� ��� ����!");
                    haveWords = true;
                    break;
                }
            }
            if(!haveWords)
            {
                arr[i] = str;
                i++;
            }
        }
        if(!str.equalsIgnoreCase("exit"))
        {
            System.out.println("������ ��������:");
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("�������� ���!");
    }
}
