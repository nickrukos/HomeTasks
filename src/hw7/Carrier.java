package hw7;
//транспортное средство
abstract public class Carrier
{
    private final boolean signColor;   //покраска нужна
    private final String type;  //тип транспортного средства
    private int wear;   //износ транспортного средства
    private final String autoNumber; //номер транспортного средства
    private String color;   //цвет
    public Carrier(String number, String color, String type, boolean signColor)
    {
        if (type == null)
        {
            throw new IllegalArgumentException("Это не транспортное средство");
        }
        if (color == null)
        {
            throw new IllegalArgumentException("Это не транспортное средство");
        }
        if(number == null || number.length() == 0 || number.length() > 10)
        {
            throw new IllegalArgumentException("Это не транспортное средство");
        }
        this.type = type;
        this.autoNumber  = number;
        System.out.println("Создан новый " + type);
        this.color = color;
        this.signColor = signColor;
        System.out.println("Новый " + type + " покрашен в " + color + " цвет");
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
