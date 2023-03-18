package hw3;

public class Task5
{
    public static void main(String[] args)
    {
        int minValue = 10, maxValue = 500;
        int randomValue = minValue + (int)(Math.random() * ((maxValue - minValue) + 1));
        if(randomValue < 200 && randomValue > 25) System.out.println(String.format("Число %s содержится в интервале (25;200)", randomValue));
        else  System.out.println(String.format("Число %s  не содержится в интервале (25;200)", randomValue));
    }
}
