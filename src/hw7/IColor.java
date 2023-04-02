package hw7;

public interface IColor
{
    default public String changeColor(String color, String type)
    {
        if (color == null || type == null)
        {
            throw new IllegalArgumentException("Это не транспортное средство");
        }
        //System.out.println("Проведена покраска " + type + " в " + color + " цвет");
        return color;
    }
}
