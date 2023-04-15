package hw11.task01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FruitStorage {
    private ArrayList<Fruit> fruits; // коллекция для хранения фруктов (коллекцию выбрать самостоятельно)
    private int totalCount;


    public FruitStorage() {
        fruits = new ArrayList<>(); // коллекция для хранения фруктов (коллекцию выбрать самостоятельно)
        totalCount = 0;
    }

    public void addFruit(Fruit newFruit) {
        if (newFruit == null) return;
        for (Fruit fruit : fruits) {
            if (fruit == newFruit) return;
            if (fruit.equals(newFruit)) {
                fruit.setCount(fruit.getCount() + newFruit.getCount());
                return;
            }
        }
        fruits.add(newFruit);
        totalCount += newFruit.getCount();
    }

    public int getNumberOfFruitsByType(Fruit.FruitType fruitType) {
        // возвращает количество фруктов типа fruitType
        if (fruits.size() == 0) return 0;
        int count = 0;
        for (var fruit : fruits) {
            if (fruit.getType() == fruitType) {
                count += fruit.getCount();
            }
        }
        return count;
    }

    public int getNumberOfFruits() {
        // возвращает количество всех фруктов (цикл не использовать)
        return totalCount;
    }

    public void increasePrice(int value) {
        // value может быть в диапазоне [10; 30)
        // увеличить цену фруктов на value процентов
        for (Fruit fruit : fruits)  fruit.setPrice(fruit.getPrice() + fruit.getPrice()*value/100);
    }

    public double getFruitsPrice() {
        // возвращает общую стоимость фруктов на складе
        double totalPrice = 0;
        for (Fruit fruit : fruits)
        {
            totalPrice += fruit.getPrice() * fruit.getCount();
        }
        return totalPrice;
    }

    public List<Fruit> getFruitsByTypeAndPrice(Fruit.FruitType fruitType, int maxPrice) {
        // maxPrice должна быть положительной
        // возвращает список, в который войдут фрукты из коллекции fruits с типом fruitType и ценой не выше maxPrice
        if(maxPrice <= 0) return Collections.emptyList();
        List <Fruit>  list = new ArrayList<>();
        for (Fruit fruit : fruits)
        {
            if(fruit.getType().equals(fruitType) && fruit.getPrice() < maxPrice)
            {
                list.add(fruit);
            }
        }
        return list;
    }
}