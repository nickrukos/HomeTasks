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
/*
    public Game()
    {
        sections = new ArrayList<>();
        currentSection = new HashMap<>();
    }
*/
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
        currentSection = sections.get(number).getNextSections();
        Set<String> keys = currentSection.keySet();
        for(String value: currentSection.values())
        {
            arrValue.add(value);
            for (String key :keys)
                if(currentSection.get(key).equals(value)) arrKey.add(key);
            if(arrKey.get(0).equals("30") || arrKey.get(0).equals("-1"))
            {
                System.out.println("You won!!!");
                return;
            }
            if(arrKey.get(0).equals("40") || arrKey.get(0).equals("-2"))
            {
                System.out.println("You lost!!!");
                return;
            }

            if(prom.equals("tt")) {
                System.out.print("3: ");
            }
            else if(!value.equals("")) {
                System.out.print("4: ");
            }
            prom = value;

            System.out.println(value);

        }
        System.out.println("Press 3 or 4 to continue Game");
    }

    public static ArrayList<String> getArrKey() {
        return arrKey;
    }

    public static ArrayList<String> getArrValue() {
        return arrValue;
    }
}
