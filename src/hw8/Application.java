package hw8;

public class Application
{
    public static void main(String[] args)
    {
        AppLogger logger01 = new Delimiter(new Upper(new ConsoleWriter()));
        logger01.log("Сообщение");
    }
}
