package hw7;

public interface IColor
{
    default public String changeColor(String color, String type)
    {
        if (color == null || type == null)
        {
            throw new IllegalArgumentException("��� �� ������������ ��������");
        }
        //System.out.println("��������� �������� " + type + " � " + color + " ����");
        return color;
    }
}
