package hw2;

public class Task4
{
    public static void main(String[] args)
    {
        int value = 67; //���������� �����
        int num1 = value / 10; //������ ����� �����
        int num2 = value % 10; //������ ����� �����
        int summa = num1 + num2;  //����� ���� �����
        System.out.println(String.format("���� - %s, ����� ���� ����� - %s",value, summa));
    }
}
