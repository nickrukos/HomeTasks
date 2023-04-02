package hw7;

public class Application
{
    public static void main(String[] args)
    {
        String [] arrColor = {"�����", "�����", "��������", "������", "����", "�������", "��������"};
        Train train01 = new Train(8,"��-7845","����� ���");
        Car car01 = new Car("�924�� 178", "������");
        Car car02 = new Car("�724�� 178","������");
        Bus bus01 = new Bus(false,"�345�� 178","���������");
        Bus bus02 = new Bus(true,"O467OO 178","���������");

        //������������ ������������ �������
        System.out.println();
        System.out.println("������������ ������������ �������");
        car01.running(car01,6);
        car02.running(car02,12);
        train01.running(train01,13);
        bus01.running(bus01,20);
        bus02.running(bus02,18);

        //������ ������������ �������
        System.out.println();
        System.out.println("������ ������������ �������");
        repairFactory factory = new repairFactory(arrColor);
        factory.add((Carrier) car01);
        factory.add((Carrier) car02);
        factory.add((Carrier) train01);
        factory.add((Carrier) bus01);
        factory.add((Carrier) bus02);
        System.out.println();
        factory.repairAll();
    }
}
