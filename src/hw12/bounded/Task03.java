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
    public static List<? super Repaintable>  Metod2(EnumMap<Repaintable.Color,List<? extends Repaintable>> map,
                                                    Repaintable.Color color )
    {
        List<Object> lst = new ArrayList<>();
        for (Map.Entry<Repaintable.Color,List<? extends Repaintable>> entry : map.entrySet())
        {
            if(entry.getKey().equals(color))
            {
                lst.add(entry.getValue());
            }
        }
        return lst;
    }

    //3-q метод
    public static void metod3(HashMap<String,Vehicle> mapIn, HashMap<String, Vehicle> mapOut,
                              int wearLevel)
    {
        for (Map.Entry<String,Vehicle> entry : mapIn.entrySet())
        {
            if(entry.getValue().getWearLevel() < wearLevel) {
                mapOut.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String,Vehicle> entryOut : mapOut.entrySet())
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

        // 3 метод:
        // написать метод, принимающий на вход 3 аргумента:
        // 2 мапы, где ключи - номера транспортных средств, значени€ - транспортные средства (например машины или автобусы)
        // и уровень износа (wearLevel)
        // в методе переместить транспортные средства из первой map во вторую, если уровень износа транспортного средства больше wearLevel
    }
}
