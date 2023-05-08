package hw15.task6;

public class RuleXls extends Check
{
    public RuleXls(String fileName)
    {
        super(fileName);
    }

    public boolean checkRule()
    {
        if(fileName.substring(fileName.lastIndexOf('.')+1).equals("xls")) return true;
        return false;
    }
}
