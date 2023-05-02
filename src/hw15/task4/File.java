package hw15.task4;

public class File
{
    public final String fileName;
    public final FileType fileType;
    public File(String fileName, FileType type)
    {
        if(fileName == null || type == null) throw new IllegalArgumentException("File doesn't exist");
        this.fileName = fileName;
        this.fileType = type;
    }
}
