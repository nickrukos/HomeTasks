package hw7;

public class repairFactory implements IColor
{
    private Carrier[] arrCarrier;
    private String[] arrColor;
    repairFactory(String[] arrColor)
    {
        this.arrCarrier = new Carrier[10];
        this.arrColor = arrColor;
    }
    public boolean add(Carrier carrier)
    {
        if (carrier == null)
        {
            throw new IllegalArgumentException("Это не транспортное средство");
        }
        for (int i = 0; i < arrCarrier.length; i++)
        {
            if(arrCarrier[i] == null) 
            {
                arrCarrier[i] = carrier;
                System.out.println(carrier.getType() + " отправлен в мастерскую");
                return true;
            }
        }
        System.out.println("В мастерской нет мест");
        return false;
    }
    public void repairAll()
    {
        for (int i = 0; i < arrCarrier.length; i++)
        {
            if (arrCarrier[i] != null)
            {
                arrCarrier[i].repair();
                //System.out.println("После ремонта износ " + arrCarrier[i].getType() + " равен " + arrCarrier[i].getWear());
                if(arrCarrier[i].isSignColor())
                {
                    arrCarrier[i].setColor(this.changeColor(arrColor[(int)(Math.random()*(arrColor.length+1))],arrCarrier[i].getType()));
                    System.out.println(arrCarrier[i].getType() + " покрашен в " + arrCarrier[i].getColor() + " цвет");
                }
                arrCarrier[i] = null;
            }
        }   
    }
}
