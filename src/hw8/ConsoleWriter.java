package hw8;

public class ConsoleWriter extends AppLogger
{
    @Override
    public void log(String data)
    {
        System.out.println("===========================================");
        System.out.println("����� � �������");
        System.out.println("===========================================");
        System.out.println(data);
        System.out.println("===========================================");
    }
}
