package hw12;

import hw11.task03.Employee;
import hw12.bounded.Repaintable;

import java.util.*;

class EntryStringIntegerComparator implements Comparator<Map.Entry<String,Integer>>
{
    public int compare(Map.Entry<String,Integer> a, Map.Entry<String,Integer> b)
    {
        if(a.getValue().compareTo(b.getValue())<0) return -1;
        else if(a.getValue().compareTo(b.getValue())>0) return 1;
        return 0;
    }

}

public class Task02 {    //� �. 2.1
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

    public static HashMap<String,Integer> wordsCount(List<String> list) //� �. 2.2
    {
        HashMap<String,Integer> map = new HashMap<>();
        for(String str : list)
        {
            map.put(str,(map.getOrDefault(str,0))+1);
        }
        return map;
    }
    public static long wordsCountLong(List<String> list, String word) //� �. 2.3.1
    {
        HashMap<String,Long> map = new HashMap<>();
        long count=0;
        for(String str : list)
        {
            map.put(str,map.getOrDefault(str,  0L)+1);
        }
        for (Map.Entry<String, Long> entry : map.entrySet())
        {
            if(entry.getValue().equals(word))
            {
                count = entry.getValue();
            }
        }
        return count;
    }
    public static HashMap<Integer,ArrayList<String>> lettersCount(List<String> list) //� �. 2.3.2
    {
        HashMap<Integer,ArrayList<String>> map = new HashMap<>();
        for(String str : list)
        {
            if (map.containsKey(str.length())) map.get(str.length()).add(str);
            else {
                ArrayList<String> arr = new ArrayList<String>();
                arr.add(str);
                map.put(str.length(), arr);
            }
        }
        return map;
    }

    public static List<String> freqWords(List<String> list)   //� �. 2.3.3
    {
        HashMap<String,Integer> mapWords = new HashMap<>();
        mapWords = wordsCount(list);
        List<String> listStr = new ArrayList<String>();
        List<Integer> listDop = new ArrayList<>(mapWords.values());
        Collections.sort(listDop);
        Collections.reverse(listDop);
        for (int i = 0; i < 10; i++)
        {
            for (Map.Entry<String, Integer> entry : mapWords.entrySet())
            {
                if(entry.getValue() == listDop.get(i))
                {
                    listStr.add(entry.getKey());
                }
            }
        }
        return listStr;
    }
    public static List<String> freqWordsV2(List<String> list)   //� ������ 4.3.3
    {
        Comparator<Map.Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        };
        HashMap<String,Integer> mapWords = new HashMap<>();
        mapWords = wordsCount(list);
        ArrayList<Map.Entry<String,Integer>> pairs = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : mapWords.entrySet())
        {
            pairs.add(entry);
        }
        Collections.sort(pairs,new EntryStringIntegerComparator());
        pairs.sort(valueComparator);   //����� � ��� �����������
        Collections.reverse(pairs);
        List<String> listStr = new ArrayList<>();
        int count = Math.min(10,listStr.size());
        for (int i = 0; i < count; i++)
        {
            listStr.add(pairs.get(i).getKey());
        }
        return listStr;
    }


    public static void main(String[] args)
    {
        // TODO (2.1) �������� ����������� �����, ������� ��������� �� ���� map (��������, firstTaskMap) � ����� (��������, city),
        //  ��������� � ���������� ������ (List) �������, ������� ������������� ����������� ������

        List <String> list = new ArrayList<>();
        HashMap<String, String> firstTaskMap = new HashMap<>();

        firstTaskMap.put("qwe", "�����");
        firstTaskMap.put("asd", "�����");
        firstTaskMap.put("zxc", "������");
        firstTaskMap.put("rty", "�����");
        firstTaskMap.put("fgh", "�������");

        String city = "�����";
        list = firstTask(firstTaskMap,city);
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println("list["+i+"] = " + list.get(i));
        }

        // TODO (2.2) ��� ������ ���� (��������, words).
        //  �������� ����������� �����, ������� ����� ���������� ���������� ���������� ���� � ������
        //  � map ���� Map<String, Integer>, ��� String - ����� � Integer - ���������� ����������

        HashMap<String,Integer> mapInteger = new HashMap<>();
        List<String> words01 = new ArrayList<>();
        words01.add("may");
        words01.add("august");
        words01.add("june");
        words01.add("may");
        words01.add("may");
        words01.add("july");
        words01.add("may");
        words01.add("august");
        words01.add("august");

        mapInteger = wordsCount(words01);
        for (Map.Entry<String, Integer> set : mapInteger.entrySet())
        {
            // Printing all elements of a Map
            System.out.println(set.getKey() + " = " + set.getValue());
        }
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
        String[] words02 = text.split(" ");
        List<String> freqWords2 = new ArrayList<String>(Arrays.asList(words02));
        List<String> resultList = new ArrayList<String>();
        resultList  = freqWordsV2(freqWords2);
        for (int i = 0; i < resultList.size(); i++)
        {
            System.out.println(resultList.get(i));
        }

    }
}