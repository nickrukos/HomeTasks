package hw10;

public class Application
{
    public static void main(String[] args)
    {
        PairContainer<Number,String> pair01 = new PairContainer<>(56.6,"String1");
        PairContainer<String,User<Number>> pair02 = new PairContainer<>("String2",new User<>(76.6,"String3"));
        PairContainer<String,PairContainer<Number,User<String>>> pair03 = new PairContainer<>("String4",new PairContainer<>(36.6,new User<>("String5","String6")));
        System.out.println(pair01.getKey() + " " + pair01.getValue().toLowerCase());
        System.out.println(pair02.getKey().toUpperCase() + " " + pair02.getValue().getId() + " " + pair02.getValue().getLogin());
        System.out.println(pair03.getKey().toLowerCase() + " " + pair03.getValue().getKey() + " " + pair03.getValue().getValue().getId()
                           + " " + pair03.getValue().getValue().getLogin());
    }
}
