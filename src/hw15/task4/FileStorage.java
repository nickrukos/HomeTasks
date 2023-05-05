package hw15.task4;

import java.util.ArrayList;
import java.util.function.Predicate;

public class FileStorage
{
    private ArrayList<String> files;
    private Predicate<CheckFile> checkFilePredicate;
    public FileStorage(Predicate<CheckFile> checkFile)
    {
       this.checkFilePredicate = checkFile;
    }

    public boolean addFile(String fileName)
    {
        CheckFile checkFile = new CheckFile(fileName);
        if(checkFilePredicate.test(checkFile)) {
            files.add(fileName);
            return true;
        }
        return false;
    }
}
