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
        // ������� �� ������ Optional:
        // 1. �������� �����, ������� ��������� �� ���� ��� ������, ��������� � ����������
        // � ���������� Optional ��������� � ����������� ���� Fruit
        // ��� Optional ��������� � null �������, ���� ��� ������ == null, � ��������� ��� ���������� ������ 1

        // 2. �������� �����, ������� ��������� �� ���� ��������� ���� Fruit
        // � ���������� true, ���� ������� �� null, ���������� ������� (getCount) ������ 5,
        // � ��������� �� ������ 100 (getPrice)
        // ������ ������� �������� ������������ ��� Optional � ���������� ������

        // 3. �������� �����, ������� ��������� �� ���� ��������� ���� Fruit
        // � ����������
        // �������� ������ (FruitType.getName()) � Optional ����������, ���� ��� ������ ���������,
        // � Optional ��������� � null �������, ���� ��� ������ == null
        // ������ ������� �������� ������������ ��� Optional � ���������� ������
    }


}
