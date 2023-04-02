package hw7;
//������������ ��������
abstract public class Carrier
{
    private final boolean signColor;   //�������� �����
    private final String type;  //��� ������������� ��������
    private int wear;   //����� ������������� ��������
    private final String autoNumber; //����� ������������� ��������
    private String color;   //����
    public Carrier(String number, String color, String type, boolean signColor)
    {
        if (type == null)
        {
            throw new IllegalArgumentException("��� �� ������������ ��������");
        }
        if (color == null)
        {
            throw new IllegalArgumentException("��� �� ������������ ��������");
        }
        if(number == null || number.length() == 0 || number.length() > 10)
        {
            throw new IllegalArgumentException("��� �� ������������ ��������");
        }
        this.type = type;
        this.autoNumber  = number;
        System.out.println("������ ����� " + type);
        this.color = color;
        this.signColor = signColor;
        System.out.println("����� " + type + " �������� � " + color + " ����");
    }

    abstract public void repair();

    public void setWear(int wear)
    {
        this.wear = wear;
    }

    public void wearDegrease(int wear)
    {
        this.wear -= wear;
    }

    public int getWear()
    {
        return wear;
    }

    public String getType()
    {
        return type;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public boolean isSignColor() {
        return signColor;
    }
}
