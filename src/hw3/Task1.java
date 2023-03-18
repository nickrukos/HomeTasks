package hw3;

public class Task1
{
    public static void main(String[] args)
    {
        int a = 13, b = 7;
        int result = a >= b ? a : b;
        System.out.println(String.format("Максимум из чисел: %s", result));
    }
}
