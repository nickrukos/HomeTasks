package hw6.Task1;

public class Alpinist
{
    private String name;
    private String address;

    public Alpinist (String name, String address)
    {
        if(name != null && name.length() > 2)
        {
            this.name = name;
        }
        else throw new IllegalArgumentException("Имя не менее 3-х символов");
        if(address != null && address.length() > 4)
        {
            this.address = address;
        }
        else throw new IllegalArgumentException("Адрес не менее 5-ти символов");
    }
}
