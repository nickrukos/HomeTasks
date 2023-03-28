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
        //нормальный продукт
        if(name != null) this.name = name;
        else throw new IllegalArgumentException("Имя - null-объект");
        if (protein < 0)
        {
            throw new IllegalArgumentException("Количество белков отрицательное");
        }
        if (fat < 0)
        {
            throw new IllegalArgumentException("Количество жиров отрицательное");
        }
        if (carb < 0)
        {
            throw new IllegalArgumentException("Количество углеводов отрицательное");
        }
        if (calorie < 0)
        {
            throw new IllegalArgumentException("Количество калорий отрицательное");
        }
        this.protein = protein;
        this.fat = fat;
        this.carb = carb;
        this.calorie = calorie;
    }
    public Food(String name, double protein, double fat, int calorie)
    {
        //продукт без углеводов
        if(name != null) this.name = name;
        else throw new IllegalArgumentException("Имя - null-объект");
        if (fat < 0)
        {
            throw new IllegalArgumentException("Количество жиров отрицательное");
        }
        if (protein < 0)
        {
            throw new IllegalArgumentException("Количество белков отрицательное");
        }
        if (calorie < 0)
        {
            throw new IllegalArgumentException("Количество калорий отрицательное");
        }
        this.fat = fat;
        this.protein = protein;
        this.calorie = calorie;
    }
    public Food(String name,  double carb, int calorie)
    {
        //продукт из одних углеводов
        if(name != null) this.name = name;
        else throw new IllegalArgumentException("Имя - null-объект");
        if (carb < 0)
        {
            throw new IllegalArgumentException("Количество углеводов отрицательное");
        }
        if (calorie < 0)
        {
            throw new IllegalArgumentException("Количество калорий отрицательное");
        }
        this.carb = carb;
        this.calorie = calorie;
    }
    public Food(String name, int calorie)
    {
        //Продукт с неизвестным составом белков, жиров, углеводов
        if(name != null) this.name = name;
        else throw new IllegalArgumentException("Имя - null-объект");
        if (calorie < 0)
        {
            throw new IllegalArgumentException("Количество калорий отрицательное");
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
