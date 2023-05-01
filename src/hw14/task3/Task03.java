package hw14.task3;

import hw14.task3.Fruit;

import java.util.Optional;

public class Task03 {
    public static boolean isFruitValid(Fruit fruit)
    {
        return Optional.ofNullable(fruit)
                .filter(f -> f.getCount() >  5)
                .filter(f -> f.getPrice() <= 100)
                .isPresent();

    }
    public static Optional<Fruit> newFruit(Fruit.FruitType type, int price,int count)
    {
        Optional<Fruit> fruit =  Optional.ofNullable(new Fruit(type,price,count));
        if(!fruit.isPresent()) return Optional.empty();
        return fruit.filter(f -> f.getPrice() >= 1).filter(f -> f.getCount() >= 1);
    }
    public static Optional<String> fruitName(Fruit fruit)
    {
        Optional<String> fruitName = Optional.ofNullable(fruit.getType().getName());
        if(!fruitName.isPresent()) return Optional.empty();
        return Optional.ofNullable(fruit.getType().getName());
    }
    public static void main(String[] args) {
        // «адани€ на методы Optional:
        // 1. написать метод, который принимает на вход тип фрукта, стоимость и количество
        // и возвращает Optional контейнер с экземпл€ром типа Fruit
        // или Optional контейнер с null ссылкой, если тип фрукта == null, а стоимость или количество меньше 1

        // 2. написать метод, который принимает на вход экземпл€р типа Fruit
        // и возвращает true, если передан не null, количество фруктов (getCount) больше 5,
        // а стоимость не больше 100 (getPrice)
        // ¬место обычных проверок использовать тип Optional и подход€щие методы

        // 3. написать метод, который принимает на вход экземпл€р типа Fruit
        // и возвращает
        // название фрукта (FruitType.getName()) в Optional контейнере, если тип фрукта определен,
        // и Optional контейнер с null ссылкой, если тип фрукта == null
        // ¬место обычных проверок использовать тип Optional и подход€щие методы
    }


}
