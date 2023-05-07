package hw15.task6;

public class RuleJson extends Check
{
    public RuleJson(String fileName)
    {
        super(fileName);
    }
    public boolean checkRule()
    {
        if(fileName.substring(fileName.lastIndexOf('.')+1).equals("json")) return true;
        return false;
    }
}
