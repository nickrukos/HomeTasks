package hw7;

public class Car extends Carrier implements IRepair
{
    public Car(String number, String color)
    {
        super(number,color,"����������", true);
    }
    public void repair()
    {
        defaultRepairing((Carrier)this);
        System.out.println("����� " + this.getType() + " ����� " + this.getWear());
        //System.out.println(super.getType() + " ��������������");
    }
}
