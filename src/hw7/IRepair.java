package hw7;

public interface IRepair  //��������� "������"
{
    //�������� ������ ������������� ��������
    default  public void defaultRepairing(Carrier carrier)
    {
        if (carrier == null)
        {
            throw new IllegalArgumentException("��� �� ������������ ��������");
        }
        carrier.wearDegrease(10);
        if(carrier.getWear() < 0) carrier.setWear(0);
        System.out.println("�������� �������� ������ " + carrier.getType());
    }
    //������������ ������������� ��������, ���������� ������
    default public void running(Carrier carrier, int yearCount)
    {
        if (carrier  == null)
        {
            throw new IllegalArgumentException("��� �� ������������ ��������");
        }
        if(4*yearCount > 100)
        {
            System.out.println("����� " + carrier.getType() + " 100%");
            carrier.setWear(100);
        }
        carrier.setWear(carrier.getWear() + 4*yearCount);
        System.out.println("����� " + carrier.getType() + " ���� " + carrier.getWear() + "%");
    }
}
