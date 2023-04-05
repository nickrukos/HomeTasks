package hw8;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class AppFileWriter implements AppLogger
{
    private final String path = "file_out.txt";
    public AppFileWriter()
    {
        File file = new File(this.path);
        if(!file.exists() || file.isDirectory())
        {
            throw new IllegalArgumentException("Указанный файл не существует или указан каталог");
        }
    }
    @Override
    public void log(String data)
    {
        try
        {
            Files.writeString(Paths.get(this.path),data, StandardOpenOption.APPEND);
            System.out.println("Данные записаны");
        }
        catch (IOException e)
        {
            System.out.println("Данные не были записаны");
        }
    }
}
