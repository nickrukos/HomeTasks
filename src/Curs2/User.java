package Curs2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;

public class User
{
    private String login;
    private String password;
    private int currentSection;

    public User(String login, String password, int currentSection)
    {
        this.login = login;
        this.password = password;
        this.currentSection = currentSection;
    }

    public static String loadUser(String login, String password, String fileName) throws IOException
    {
        RandomAccessFile file = new RandomAccessFile(fileName,"rw");
        file.seek(0);
        String record = null;
        while((record = file.readLine()) != null)
        {
            String[] words = record.split(";");
            if(words[0].equals(login) && words[1].equals(password))  return words[2];
        }
        return null;
    }
    public void saveUser(String fileName) throws IOException
    {
        RandomAccessFile file = new RandomAccessFile(fileName,"rw");
        String record = this.login + ";" + this.password + ";" + this.currentSection;
        file.seek(file.length());
        file.writeChars(record);
        file.close();
    }
}
