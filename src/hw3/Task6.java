package hw3;

public class Task6
{
    public static void main(String[] args)
    {
        double summa = 15_347.0;
        int saleCode = 1111;
        switch (saleCode)
        {
            case 4525:
                System.out.println(String.format("Сумма покупки: %s", summa -= 0.3 * summa));
                break;
            case 6424:
            case 7012:
                System.out.println(String.format("Сумма покупки: %s", summa -= 0.2 * summa));
                break;
            case 7647:
            case 9011:
            case 6612:
                System.out.println(String.format("Сумма покупки: %s", summa -= 0.1 * summa));
                break;
            default:
                System.out.println(String.format("Сумма покупки: %s", summa ));
        }
    }
}
