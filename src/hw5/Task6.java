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
            if (str.equalsIgnoreCase("exit") == true) break;
            for (int j = 0; j < i; j++)
            {
                if (arr[j].equalsIgnoreCase(str) == true)
                {
                    System.out.println("����� ����� ��� ����!");
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
            System.out.println("������ ��������:");
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("�������� ���!");
    }
}
