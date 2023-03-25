package hw5;

import java.util.Locale;
import java.util.Scanner;

public class Task1
{
    public static void main(String[] args)
    {
        String strDop = "";
        System.out.println("¬ведите строку, дл€ выхода наберите \"exit\":");
        Scanner vvod = new Scanner(System.in);
        String str = vvod.nextLine();
        while (str.equalsIgnoreCase("exit") == false)
        {
            str = str.strip();
            strDop = str.substring(0,1);
            strDop = strDop.toUpperCase(Locale.ROOT);
            str = str.substring(1);
            str = str.toLowerCase(Locale.ROOT);
            str = strDop + str;
            System.out.println(str);
            str = vvod.nextLine();
        }
        System.out.println("’орошего дн€!");
    }
}
