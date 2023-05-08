package hw15.task7;


import java.util.ArrayList;

public class FileStorage {
    private ArrayList<String> files;
    private Check check;

    public FileStorage(Check check) {
        this.check = check;
        this.files = new ArrayList<>();
    }

    public boolean addFile(String fileName) {
        boolean valid = NextObj.first.checkRule(fileName);
        for (int i = 0; i < NextObj.checks.size(); i++) {
            if(NextObj.checks.get(i).getCondition() == "And")
                valid = valid && NextObj.checks.get(i).checkRule(fileName);
            if(NextObj.checks.get(i).getCondition() == "Or")
                valid = valid || NextObj.checks.get(i).checkRule(fileName);
        }
        if(valid) files.add(fileName);
        return valid;
    }
}