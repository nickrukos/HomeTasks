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

    //3-q �����
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

        // 3 �����:
        // �������� �����, ����������� �� ���� 3 ���������:
        // 2 ����, ��� ����� - ������ ������������ �������, �������� - ������������ �������� (�������� ������ ��� ��������)
        // � ������� ������ (wearLevel)
        // � ������ ����������� ������������ �������� �� ������ map �� ������, ���� ������� ������ ������������� �������� ������ wearLevel
    }
}
