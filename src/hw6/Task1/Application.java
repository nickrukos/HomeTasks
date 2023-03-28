package hw6.Task1;

public class Application
{
    public static void main(String[] args)
    {
        Mountain elbrus = new Mountain("Эльбрус", "Россия", 5642);
        Mountain kazbek = new Mountain("Казбек", "Россия", 5033);
        Mountain pamir = new Mountain("Памир", "Таджикистан", 7649);
        Alpinist ivan = new Alpinist("Иван", "Санкт-Петербург");
        Alpinist mark = new Alpinist("Mark", "New-York");
        Alpinist alex = new Alpinist("Alex", "London");
        Alpinist piere = new Alpinist("Piere", "Paris");
        Alpinist ali = new Alpinist("Ali", "Istanbul");
        Alpinist yoko = new Alpinist("Yoko", "Tokyo");
        Alpinist usuku = new Alpinist("Usuku", "Lagos");

        Group groupElbrus = new Group(elbrus,3);
        Group groupKazbek = new Group(kazbek,3);
        Group groupPamir = new Group(pamir,3);

        groupElbrus.addAlpinist(ivan);
        groupElbrus.addAlpinist(mark);
        groupElbrus.addAlpinist(alex);

        groupKazbek.addAlpinist(piere);
        groupKazbek.addAlpinist(ali);

        groupPamir.addAlpinist(yoko);
        groupPamir.addAlpinist(usuku);
    }
}
