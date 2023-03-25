package hw5;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Task3
{
    public static void main(String[] args)
    {
        int index = 0, count = 0;
        String text = "", str = "JAVA";
        URL url = Task3.class.getResource("doc.txt");
        File file = new File(url.getPath());
        try
        {
            Scanner sc = new Scanner(file, "Windows-1251");
            while (sc.hasNextLine())
            {
                text = sc.nextLine();
                index = 0;
                while (true)
                {
                    index = text.indexOf(str, index);
                    if (index != -1)
                    {
                        count ++;
                        index += str.length();
                    }
                    else {
                        break;
                    }
                }
            }
            System.out.println("¬ исходном тексте слово " + str + " встретилось " + count + " раз(a)!");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
