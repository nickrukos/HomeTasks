package hw6.Task2;

public class Application
{
    public static void main(String[] args)
    {
        Food potatoes = new Food("картофель",2,0.4,16.1,76);
        Food lamb = new Food("баранина", 16.3, 15.3, 203);
        Food persimmon = new Food("хурма", 0.5, 0.0, 15.9,62);
        Food pork = new Food("свиные сардельки",10.1,31.6,1.9,332);
        Food unknown = new Food("неизвестный", 54);

        MyFoods diet = new MyFoods(20,17,20,220);
        System.out.println("Добавление продуктов:");
        System.out.println(diet.addFood(potatoes));
        System.out.println(diet.addFood(lamb));
        System.out.println(diet.addFood(persimmon));
        System.out.println(diet.addFood(pork));
        System.out.println(diet.addFood(unknown));

        System.out.println("Мои продукты:");
        diet.listFoods();
    }
}
