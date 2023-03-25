package hw5;

import java.util.Arrays;

public class Task7
{
    public static void main(String[] args)
    {
        String text = "в предложении все слова разной длины";
        String[] words = text.split(" ");
        System.out.println(Arrays.toString(words));
        int temp = words[0].length();
        String str = words[0];
        for (int i = 1; i < words.length; i++)
        {
            if (words[i].length() > temp)
            {
                temp = words[i].length();
                str = words[i];
            }
        }
        System.out.println("Самое длинное слово: " + str);
    }
}
