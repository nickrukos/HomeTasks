package hw15.task6;

import hw15.task4.CheckFile;

import java.util.ArrayList;
import java.util.function.Predicate;

public class FileStorage {
    private ArrayList<String> files;
    private Check check;

    public FileStorage(Check check) {
        this.check = check;
        this.files = new ArrayList<>();
    }

    public boolean addFile(String fileName) {
        check.doCheck(fileName);
        if (check.isResult()) {
            files.add(fileName);
            return true;
        }
        return false;
    }

    public void setCheck(Check check) {
        this.check = check;
    }

    public Check getCheck() {
        return check;
    }
}