package hw7;

public class Car extends Carrier implements IRepair
{
    public Car(String number, String color)
    {
        super(number,color,"автомобиль", true);
    }
    public void repair()
    {
        defaultRepairing((Carrier)this);
        System.out.println("Износ " + this.getType() + " равен " + this.getWear());
        //System.out.println(super.getType() + " отремонтирован");
    }
}
