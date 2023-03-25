package hw5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Task2
{
    public static void main(String[] args)
    {
        CharSequence str = "JAVA", strChange = "PYTHON";
        String text = "";
        URL url = Task2.class.getResource("doc.txt");
        File file = new File(url.getPath());
        try
        {
            Scanner sc = new Scanner(file, "Windows-1251");
            while (sc.hasNextLine())
            {
                text = sc.nextLine();
                text = text.replace(str,strChange);
                System.out.println(text);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
