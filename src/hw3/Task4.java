package hw3;

public class Task4
{
    public static void main(String[] args)
    {
        int count = 78;
        if ((count >= 90) && (count <= 100)) System.out.println("�������");
        else if ((count >= 60) && (count <= 89)) System.out.println("������");
        else if ((count >= 40) && (count <= 59)) System.out.println("�����������������");
        else if ((count >= 0) && (count <= 39)) System.out.println("���������� ��� ���!");
        else System.out.println("���������� ������ ������� �����������!");
    }
}
