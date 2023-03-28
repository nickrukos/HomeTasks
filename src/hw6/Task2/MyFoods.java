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
            throw new IllegalArgumentException("Количество белков отрицательное");
        }
        if (maxFat < 0)
        {
            throw new IllegalArgumentException("Количество жиров отрицательное");
        }
        if (maxCarb < 0)
        {
            throw new IllegalArgumentException("Количество углеводов отрицательное");
        }
        if (maxCalorie < 0)
        {
            throw new IllegalArgumentException("Количество калорий отрицательное");
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
            return "Слишком много белков";
        }
        if(food.getFat() > maxFat)
        {
            return "Слишком много жиров";
        }
        if(food.getCarb() > maxCarb)
        {
            return "Слишком много углеводов";
        }
        if(food.getCalorie() > maxCalorie)
        {
            return "Слишком много калорий";
        }
        foodList.add(food);
        return "Продукт " + food.getName() + " добавлен";
    }
    public void listFoods()
    {
        for (int i = 0; i < foodList.size(); i++)
        {
            System.out.println(foodList.get(i).getName());
        }
    }
}
