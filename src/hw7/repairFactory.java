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
            throw new IllegalArgumentException("��� �� ������������ ��������");
        }
        for (int i = 0; i < arrCarrier.length; i++)
        {
            if(arrCarrier[i] == null) 
            {
                arrCarrier[i] = carrier;
                System.out.println(carrier.getType() + " ��������� � ����������");
                return true;
            }
        }
        System.out.println("� ���������� ��� ����");
        return false;
    }
    public void repairAll()
    {
        for (int i = 0; i < arrCarrier.length; i++)
        {
            if (arrCarrier[i] != null)
            {
                arrCarrier[i].repair();
                //System.out.println("����� ������� ����� " + arrCarrier[i].getType() + " ����� " + arrCarrier[i].getWear());
                if(arrCarrier[i].isSignColor())
                {
                    arrCarrier[i].setColor(this.changeColor(arrColor[(int)(Math.random()*(arrColor.length+1))],arrCarrier[i].getType()));
                    System.out.println(arrCarrier[i].getType() + " �������� � " + arrCarrier[i].getColor() + " ����");
                }
                arrCarrier[i] = null;
            }
        }   
    }
}
