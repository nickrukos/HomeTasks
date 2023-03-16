package hw2;

public class Task3
{
    public static void main(String[] args) {
        //время (час)
        double time = 4.5d;
        //расстояние (км.)
        double distance = 35.6d;
        //скорость (м./сек.)
        double speed = (distance * 1000)/(time * 3600);
        System.out.println(String.format("Время - %s час., Расстояние - %s км., Скорость - %s м./сек.", time, distance,speed));
    }
}
