package hw2;

public class Task4
{
    public static void main(String[] args)
    {
        int value = 67; //двухначное число
        int num1 = value / 10; //первая цифра числа
        int num2 = value % 10; //вторая цифра числа
        int summa = num1 + num2;  //сумма цифр числа
        System.out.println(String.format("Чсло - %s, сумма цифр числа - %s",value, summa));
    }
}
