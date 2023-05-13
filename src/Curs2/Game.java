package Curs2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game
{
    private ArrayList<Section> sections;
    private HashMap<String,String> currentSection;

    public Game()
    {
        sections = new ArrayList<>();
        currentSection = new HashMap<>();
    }

    public void setSections(String fileName)
    {
        //String fileName = "src/curs2/file.txt";
        String buffer;
        ArrayList<Section> sections = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanner.useDelimiter("###");
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
    public void DrawSection(int number)
    {
        String prom = "tt";
        System.out.println(sections.get(number).getTitle());
        System.out.println(sections.get(number).getText());
        currentSection = sections.get(number).getNextSections();
        for(String value: currentSection.values())
        {
            if(prom.equals("tt")) System.out.print("3: ");
            else System.out.print("4: ");
            prom = value;
            System.out.println(value);
        }
        System.out.println("Press 3 or 4 to continue Game");
    }
}
