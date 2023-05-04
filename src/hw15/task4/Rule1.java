package hw15.task4;
import java.io.File;

public class Rule1 implements ValidateFile
{
    public boolean rule(CheckFile checkFile)
    {
        File f = new File(checkFile.fileName);
        if(f.exists()) return true;
        return false;
    }
}
