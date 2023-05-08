package hw15.task7;

import hw15.task7.Check;

public class RuleXls extends Check
{
    public boolean checkRule(String fileName)
    {
        if(fileName.substring(fileName.lastIndexOf('.')+1).equals("xls")) return true;
        return false;
    }
}
