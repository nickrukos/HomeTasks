package hw3;

public class Task3
{
    public static void main(String[] args)
    {
        int monthNumber = 24;
        if((monthNumber >= 1 && monthNumber <= 2) || (monthNumber == 12)) System.out.println("Сейчас зима");
        else if ((monthNumber >= 3) && (monthNumber <= 5)) System.out.println("Сейчас весна");
        else if ((monthNumber >= 6) && (monthNumber <= 8)) System.out.println("Сейчас лето");
        else if ((monthNumber >= 9) && (monthNumber <= 11)) System.out.println("Сейчас осень");
        else System.out.println("Номер месяца введен неправильно!");
    }
}
