package hw15.task7;

public class RuleJson extends Check
{
     public boolean checkRule(String fileName)
    {
        if(fileName.substring(fileName.lastIndexOf('.')+1).equals("json")) return true;
        return false;
    }
}
