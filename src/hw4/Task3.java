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
            System.out.println("������� ����� ����� � ��������� [1;9], ��� 0 ��� ������");
            int userNumber = userValue.nextInt();
            if (userNumber == 0)
            {
                System.out.println("������� �� ������!");
                break;
            }
            if (randomValue == userNumber)
            {
                System.out.println("�� �������!!!");
                break;
            }
            if(userNumber > randomValue) System.out.println("���� ����� ������!");
            else System.out.println("���� ����� ������!");
        }
    }
}
