package Curs2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Game
{
    private static ArrayList<Section> sections = new ArrayList<>();
    private static ArrayList<String> arrKey = new ArrayList<>();
    private static ArrayList<String> arrValue = new ArrayList<>();
    private static HashMap<String,String> currentSection = new HashMap<>();
    private static String numberSection;

    public static void setSections(String fileName)
    {
        //String fileName = "src/curs2/file.txt";
        String buffer;
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanner = scanner.useDelimiter("###");
        while (scanner.hasNext())
        {
            //System.out.println(scanner.next());
            Section section = new Section();
            buffer = scanner.next();
            buffer.replaceAll("\\p{Cntrl}", "");
            buffer.replaceAll("\\r\\n", "");
            String[] words = buffer.split(";");
            section.setNumber(words[0]);
            section.setTitle(words[1]);
            section.setText(words[2]);
            section.setNextSection(words[3],words[4]);
            section.setNextSection(words[5],words[6]);
            sections.add(section);
        }
        scanner.close();
    }
    public static void DrawSection(int number)
    {
        String prom = "tt";
        arrKey.clear();
        arrValue.clear();
        System.out.println(sections.get(number).getTitle());
        System.out.println(sections.get(number).getText());
        numberSection = Integer.toString(number);
        currentSection = sections.get(number).getNextSections();
        Set<String> keys = currentSection.keySet();
        for(String value: currentSection.values())
        {
            arrValue.add(value);
            for (String key :keys)
                if(currentSection.get(key).equals(value)) arrKey.add(key);
            String str = arrKey.get(0);
            str = str.replaceAll("\\r\\n", "");
            if(str.equals("30") || str.equals("-1"))
            {
                System.out.println("Вы выиграли!!!");
                return;
            }
            if(str.equals("40") || str.equals("-2"))
            {
                System.out.println("Вы проиграли!!!");
                return;
            }
            if(prom.equals("tt"))  System.out.print("3: ");
            else System.out.print("4: ");
            value = value.replaceAll("\\r\\n", "");
            System.out.println(value);
            prom = value;
        }
    }

    public static ArrayList<String> getArrKey() {
        return arrKey;
    }

    public static ArrayList<String> getArrValue() {
        return arrValue;
    }

    public static String getNumberSection() {
        return numberSection;
    }
}
