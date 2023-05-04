package hw15.task4;
import java.io.File;
public class Rule2 implements ValidateFile
{
    public boolean rule(CheckFile checkFile)
    {
        File f = new File(checkFile.fileName);
        if(checkFile.fileName.substring(checkFile.fileName.lastIndexOf('.')+1).equals(CheckFile.FileType.XML)) return true;
        return false;
    }
}
