package hw2;

public class Task3
{
    public static void main(String[] args) {
        //����� (���)
        double time = 4.5d;
        //���������� (��.)
        double distance = 35.6d;
        //�������� (�./���.)
        double speed = (distance * 1000)/(time * 3600);
        System.out.println(String.format("����� - %s ���., ���������� - %s ��., �������� - %s �./���.", time, distance,speed));
    }
}
