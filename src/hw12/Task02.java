package hw12;

import java.util.*;

public class Task02 {
    public static List <String> firstTask(HashMap<String, String> map, String city)
    {
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet())
        {
            if(entry.getValue().equals(city))
            {
                list.add(entry.getKey());
            }
        }
        return list;
    }

    public static HashMap<String,Integer > wordsCount(List<String> list)
    {
        HashMap<String,Integer>
    }

    public static void main(String[] args) {
        // FIXME:: � �������� �� ������������ lambda ��������� � stream API

        // TODO (2.1) �������� ����������� �����, ������� ��������� �� ���� map (��������, firstTaskMap) � ����� (��������, city),
        //  ��������� � ���������� ������ (List) �������, ������� ������������� ����������� ������

        HashMap<String, String> firstTaskMap = new HashMap<>();
        firstTaskMap.put("qwe", "�����");
        firstTaskMap.put("asd", "�����");
        firstTaskMap.put("zxc", "������");
        firstTaskMap.put("rty", "�����");
        firstTaskMap.put("fgh", "�������");

        String city = "�����";


        // TODO (2.2) ��� ������ ���� (��������, words).
        //  �������� ����������� �����, ������� ����� ���������� ���������� ���������� ���� � ������
        //  � map ���� Map<String, Integer>, ��� String - ����� � Integer - ���������� ����������

        List<String> words = new ArrayList<>();
        words.add("may");
        words.add("august");
        words.add("june");
        words.add("may");
        words.add("may");
        words.add("july");
        words.add("may");
        words.add("august");
        words.add("august");


        // TODO (2.3) ������� �� ������ (��������, text). �� ������ ����� - ������� ���� ����� (����� �����������):
        //  1. �������� �����, ����������� �� ���� ����� � ������������ ������� ������������� ������� ����� � ������
        //  (Map<String, Long>, ��� - ����� (String) - �����, �������� (Long) - ������� �������������)
        //  2. �������� �����, ������� �������� ��� ����� � ������ �� ���������� ����:
        //  ��������, � ���� ������ ������� �����: 3 - [the, war, jar, get, met...], � ������ 2 - [on, up, no, of...]
        //  (Map<Integer, ArrayList<String>>, ��� - ����� (Integer) - ���������� ����, �������� (ArrayList<String>) - �����)
        //  3. �������� �����, ������� ������� � ������� ��� 10 ����� ����� ����������� � ������ ���� (������� � �������� ���� ������� �� �����)

        // � ������ ���������� ������ ����� � ���������� �������
        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";

    }
}