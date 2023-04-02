package hw7;

public class Bus extends Carrier implements IRepair
{
    private boolean wifi;
    public Bus(boolean wifi, String number, String color)
    {
        super(number,color,"�������", false);
        this.wifi = wifi;
    }
    @Override
    public void repair()
    {
        defaultRepairing((Carrier)this);
        System.out.println("����� " + this.getType() + " ����� " + this.getWear());
        if (!wifi) wifi = true;
        System.out.println(super.getType() + " ��������������");
    }
}
