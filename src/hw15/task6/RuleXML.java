package hw15.task6;

public class RuleXML extends Check
{
    public RuleXML(String fileName)
    {
        super(fileName);
    }

    public boolean checkRule()
    {
        if(fileName.substring(fileName.lastIndexOf('.')+1).equals("xml")) return true;
        return false;
    }
}
