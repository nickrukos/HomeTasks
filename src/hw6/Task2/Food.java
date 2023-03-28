package hw6.Task2;

public class Food
{

    private String name;
    private double protein;
    private double fat;
    private double carb;
    private int calorie;

    public Food(String name, double protein, double fat, double carb, int calorie)
    {
        //���������� �������
        if(name != null) this.name = name;
        else throw new IllegalArgumentException("��� - null-������");
        if (protein < 0)
        {
            throw new IllegalArgumentException("���������� ������ �������������");
        }
        if (fat < 0)
        {
            throw new IllegalArgumentException("���������� ����� �������������");
        }
        if (carb < 0)
        {
            throw new IllegalArgumentException("���������� ��������� �������������");
        }
        if (calorie < 0)
        {
            throw new IllegalArgumentException("���������� ������� �������������");
        }
        this.protein = protein;
        this.fat = fat;
        this.carb = carb;
        this.calorie = calorie;
    }
    public Food(String name, double protein, double fat, int calorie)
    {
        //������� ��� ���������
        if(name != null) this.name = name;
        else throw new IllegalArgumentException("��� - null-������");
        if (fat < 0)
        {
            throw new IllegalArgumentException("���������� ����� �������������");
        }
        if (protein < 0)
        {
            throw new IllegalArgumentException("���������� ������ �������������");
        }
        if (calorie < 0)
        {
            throw new IllegalArgumentException("���������� ������� �������������");
        }
        this.fat = fat;
        this.protein = protein;
        this.calorie = calorie;
    }
    public Food(String name,  double carb, int calorie)
    {
        //������� �� ����� ���������
        if(name != null) this.name = name;
        else throw new IllegalArgumentException("��� - null-������");
        if (carb < 0)
        {
            throw new IllegalArgumentException("���������� ��������� �������������");
        }
        if (calorie < 0)
        {
            throw new IllegalArgumentException("���������� ������� �������������");
        }
        this.carb = carb;
        this.calorie = calorie;
    }
    public Food(String name, int calorie)
    {
        //������� � ����������� �������� ������, �����, ���������
        if(name != null) this.name = name;
        else throw new IllegalArgumentException("��� - null-������");
        if (calorie < 0)
        {
            throw new IllegalArgumentException("���������� ������� �������������");
        }
    }

    public double getProtein() {
        return protein;
    }

    public double getFat() {
        return fat;
    }

    public double getCarb() {
        return carb;
    }

    public int getCalorie() {
        return calorie;
    }

    public String getName()
    {
        return name;
    }
}
