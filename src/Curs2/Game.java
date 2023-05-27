package Curs2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
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
    private static String currentLogin;
    private static String currentPassword;
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
        System.out.print(sections.get(number).getTitle());
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

    public static String loadUser(String login, String password, String fileName) throws IOException
    {
        RandomAccessFile file = new RandomAccessFile(fileName,"rw");
        if(file.length() == 0) return null;
        file.seek(0);
        String record = null;
        while(file.getFilePointer() < file.length())
        {
            record = file.readUTF();
            String[] words = record.split(";");
            if(words[0].equals(login) && words[1].equals(password))
            {
                file.close();
                return record;
            }
        }
        file.close();
        return null;
    }

    public static void saveUser(String fileName) throws IOException
    {
        RandomAccessFile file = new RandomAccessFile(fileName,"rw");
        String record = currentLogin + ";" + currentPassword + ";" + numberSection;
        String fileRecord = null;
        long offset=0;
        if(file.length() !=0)
        {
            file.seek(0);
            while (file.getFilePointer() < file.length()) {
                fileRecord = file.readUTF();
                String[] words = fileRecord.split(";");
                if (words[0].equals(currentLogin) && words[1].equals(currentPassword)) break;
                offset += (fileRecord.getBytes().length+2);
            }
        }
        file.seek(0);
        file.seek(offset);
        file.writeUTF(record);
        file.close();
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

    public static String getCurrentLogin() {
        return currentLogin;
    }

    public static String getCurrentPassword() {
        return currentPassword;
    }

    public static void setCurrentLogin(String currentLogin) {
        Game.currentLogin = currentLogin;
    }

    public static void setCurrentPassword(String currentPassword) {
        Game.currentPassword = currentPassword;
    }

    public static void setNumberSection(String numberSection) {
        Game.numberSection = numberSection;
    }
}
