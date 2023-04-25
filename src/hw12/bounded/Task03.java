package hw12.bounded;

import java.util.*;

public class Task03
{
    //����� 1
    public static void metod1(List<? extends Repaintable> list)
    {
        for (Repaintable lst : list)
        {
            lst.changeColor(Repaintable.Color.BLACK);
        }
    }

    //����� 2
    public static List<? extends Repaintable>  Metod2(Map<Repaintable.Color,? extends List<? extends Repaintable>> map,
                                                      Repaintable.Color color )
    {
        if (color == null) return null;
        return map.get(color);
    }

    //3-q �����
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
        // �������� �� �������:
        // 1. generic � java �����������. ��� ������� �� ��- � �����������������?
        /*
            ��������������/������������������ - ����������/��������� ������� ������������ ��� ����������� �����,
             �������������� - ���������� <? extend T>
             ����������������� - ���������� <? super T>
         */
        // 2. ��� ����� sendRequest(List<? extends Resources> list) �� ������ sendRequest(List<Resources> list)
        /* � ������ ����� ����� �������� �� ������ ��� Resources, �� � ���� ��� ��������,
           �� ��������� ����� �������� � ������ ������, �� ����������� null
         */

        // �������� ��������� static ������ (��� ����� �� ������ bounded):
        // 1 �����:
        // �������� �����, � ������� ����� �������� ������ �������� ������ ����, ������������ Repaintable ���������
        // (��������, ������ ����� ��� ������ �����������)
        // � ������ ���� �������� �� ������ ������ ��������������� Repaintable.Color.BLACK ����
        //public static void Repaint(List<? extends Repaintable> list)
        // 2 �����:
        // �������� �����, � ������� ����� �������� ��� ���������:
        // 1 �������� - map, ��� ����� - Repaintable.Color,
        // � �������� - ������ (List, ArrayList ��� LinkedList) �������� ������ ����,
        // ������������ Repaintable ��������� (��������, ������ ����� ��� ������ �����������)
        // 2 �������� - ���� (Repaintable.Color color)
        // ����� ���������� ������ �������� ������ ����, ������������ Repaintable ���������
        // (��������, ������ ����� ��� ������ �����������) ����� color
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
        // 3 �����:
        // �������� �����, ����������� �� ���� 3 ���������:
        // 2 ����, ��� ����� - ������ ������������ �������, �������� - ������������ �������� (�������� ������ ��� ��������)
        // � ������� ������ (wearLevel)
        // � ������ ����������� ������������ �������� �� ������ map �� ������, ���� ������� ������ ������������� �������� ������ wearLevel
    }
}
