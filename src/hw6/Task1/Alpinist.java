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
        else throw new IllegalArgumentException("��� �� ����� 3-� ��������");
        if(address != null && address.length() > 4)
        {
            this.address = address;
        }
        else throw new IllegalArgumentException("����� �� ����� 5-�� ��������");
    }
}
