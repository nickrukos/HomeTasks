package hw6.Task2;

import java.util.ArrayList;

public class MyFoods
{
    private double maxProtein;
    private double maxFat;
    private double maxCarb;
    private int maxCalorie;
    private ArrayList<Food> foodList;

    public MyFoods(double maxProtein, double maxFat, double maxCarb, int maxCalorie)
    {
        if (maxProtein < 0)
        {
            throw new IllegalArgumentException("���������� ������ �������������");
        }
        if (maxFat < 0)
        {
            throw new IllegalArgumentException("���������� ����� �������������");
        }
        if (maxCarb < 0)
        {
            throw new IllegalArgumentException("���������� ��������� �������������");
        }
        if (maxCalorie < 0)
        {
            throw new IllegalArgumentException("���������� ������� �������������");
        }
        this.maxProtein = maxProtein;
        this.maxFat = maxFat;
        this.maxCarb = maxCarb;
        this.maxCalorie = maxCalorie;
        this.foodList = new ArrayList<>();
    }
    public String addFood(Food food)
    {
        if(food.getProtein() > maxProtein)
        {
            return "������� ����� ������";
        }
        if(food.getFat() > maxFat)
        {
            return "������� ����� �����";
        }
        if(food.getCarb() > maxCarb)
        {
            return "������� ����� ���������";
        }
        if(food.getCalorie() > maxCalorie)
        {
            return "������� ����� �������";
        }
        foodList.add(food);
        return "������� " + food.getName() + " ��������";
    }
    public void listFoods()
    {
        for (int i = 0; i < foodList.size(); i++)
        {
            System.out.println(foodList.get(i).getName());
        }
    }
}
