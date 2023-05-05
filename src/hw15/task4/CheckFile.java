package hw15.task4;

public class CheckFile
{
    public final String fileName;
    public CheckFile(String fileName)
    {
        if(fileName == null) throw new IllegalArgumentException("File doesn't exist");
        this.fileName = fileName;
    }

}
