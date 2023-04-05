package hw8;

public class ConsoleWriter implements AppLogger
{
    public void log(String data)
    {
        System.out.println("===========================================");
        System.out.println("Вывод в консоль");
        System.out.println("===========================================");
        System.out.println(data);
        System.out.println("===========================================");
    }
}
