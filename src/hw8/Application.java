package hw8;

public class Application
{
    public static void main(String[] args)
    {
        AppLogger logger01 = new Delimiter(new Upper(new ConsoleWriter()));
        logger01.log("Сообщение1");
        AppLogger logger02 = new Upper(new Delimiter(new ConsoleWriter()));
        logger02.log("Сообщение2");
    }
}
