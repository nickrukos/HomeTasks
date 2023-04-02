package hw7;
//����� - �����
public class Train extends Carrier implements IRepair {
    private int countCarriage;

    public Train(int countCarriage, String number, String color) {
        super(number, color, "�����",false);
        this.countCarriage = countCarriage;
    }
    @Override
    public void repair() //������ ��� ���������� ������
    {
        defaultRepairing((Carrier)this);
        System.out.println("����� " + this.getType() + " ����� " + this.getWear());
        if (Math.random() < 0.5) {
            this.countCarriage++;
            System.out.println("� ������ �������� �����");
        }
        System.out.println(super.getType() + " ��������������");
    }
}
