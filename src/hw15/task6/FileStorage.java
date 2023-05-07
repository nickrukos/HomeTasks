package hw15.task6;

import hw15.task4.CheckFile;

import java.util.ArrayList;
import java.util.function.Predicate;

public class FileStorage
{
    private ArrayList<String> files;
    private Check check;
    public FileStorage(Check check)
    {
       this.check = check;
       this.files = new ArrayList<>();
    }

    public boolean addFile(String fileName)
    {
        check.setFileName(fileName);
        check.doCheck();
        if(check.isResult())
        {
            files.add(fileName);
            return true;
        }
        return false;
    }
}
