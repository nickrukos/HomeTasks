package hw15.task4;

public class CheckFile
{
    public final String fileName;
    public final FileType fileType;
    public CheckFile(String fileName, FileType type)
    {
        if(fileName == null) throw new IllegalArgumentException("File doesn't exist");
        this.fileName = fileName;
        this.fileType = type;
    }
    public enum FileType
    {
        XML,TXT,JSON,XSLX
    }
}
