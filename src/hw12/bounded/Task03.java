package hw12.bounded;

import java.util.*;

public class Task03
{
    //метод 1
    public static void metod1(List<? extends Repaintable> list)
    {
        for (Repaintable lst : list)
        {
            lst.changeColor(Repaintable.Color.BLACK);
        }
    }

    //метод 2
    public static List<? extends Repaintable>  Metod2(Map<Repaintable.Color,? extends List<? extends Repaintable>> map,
                                                      Repaintable.Color color )
    {
        if (color == null) return null;
        return map.get(color);
    }

    //3-q метод
    public static void metod3(HashMap<String, ? extends Vehicle> mapIn, HashMap<String, ? super Vehicle> mapOut,
                              int wearLevel)
    {
        for (Map.Entry<String, ? extends Vehicle> entry : mapIn.entrySet())
        {
            if(entry.getValue().getWearLevel() > wearLevel) {
                mapOut.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String,? super Vehicle> entryOut : mapOut.entrySet())
        {
            mapIn.entrySet().removeIf(entry->entry.getKey().equals(entryOut.getKey()));
        }
    }

    public static void main(String[] args, Object list) {
        // ќтветить на вопросы:
        // 1. generic в java инвариантны. как достичь их ко- и контрвариантности?
        /*
             овариантность/контравариантность - сохранение/обращение пор€дка наследовани€ дл€ производных типов,
              овариантность - используем <? extend T>
              онтрвариантность - используем <? super T>
         */
        // 2. „ем метод sendRequest(List<? extends Resources> list) от метода sendRequest(List<Resources> list)
        /* ¬ первый метод можно передать не только тип Resources, но и всех его потомков,
           но добавл€ть новые элементы в список нельз€, за исключением null
         */

        // Ќаписать следующие static методы (дл€ типов из пакета bounded):
        // 1 метод:
        // написать метод, в который можно передать список объектов любого типа, реализующего Repaintable интерфейс
        // (например, список машин или список велосипедов)
        // в методе всем объектам из списка должен устанавливатьс€ Repaintable.Color.BLACK цвет
        //public static void Repaint(List<? extends Repaintable> list)
        // 2 метод:
        // написать метод, в который можно передать два аргумента:
        // 1 аргумент - map, где ключи - Repaintable.Color,
        // а значени€ - списки (List, ArrayList или LinkedList) объектов любого типа,
        // реализующего Repaintable интерфейс (например, список машин или список велосипедов)
        // 2 аргумент - цвет (Repaintable.Color color)
        // метод возвращает список объектов любого типа, реализующего Repaintable интерфейс
        // (например, список машин или список велосипедов) цвета color
        HashMap<Repaintable.Color, ArrayList<Car>> colorCars = new HashMap<Repaintable.Color, ArrayList<Car>>();
        List<Repaintable> lst02 = new ArrayList<>(Metod2(colorCars, Repaintable.Color.BLUE));
        HashMap<String, Car> carsMap = new HashMap<>();
        HashMap<String, Vehicle> vehicleMap = new HashMap<>();

        metod3(carsMap, vehicleMap, 3);

        vehicleMap.put("cfdavad", new Bus("cfdavad"));
        vehicleMap.put("E001ZX",new Car(Repaintable.Color.ORANGE,"E001ZX"));
        Car car02 = new Car(Repaintable.Color.BLUE,"B003XC");
        vehicleMap.put("B003XC",car02);
        Vehicle vehicle = vehicleMap.get("cfdavad");
        // 3 метод:
        // написать метод, принимающий на вход 3 аргумента:
        // 2 мапы, где ключи - номера транспортных средств, значени€ - транспортные средства (например машины или автобусы)
        // и уровень износа (wearLevel)
        // в методе переместить транспортные средства из первой map во вторую, если уровень износа транспортного средства больше wearLevel
    }
}
