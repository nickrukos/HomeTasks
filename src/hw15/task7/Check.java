package hw15.task7;

import java.util.ArrayList;

abstract public class Check
{
    private static int count = 0;
    private Check and;
    private Check or;
    private String condition;
    abstract boolean checkRule(String fileName);
    public Check()
    {
        if(count == 0) NextObj.first = this;
        count ++;
    }

    public Check addRule(Check nextCheck)
    {
        and = nextCheck;
        and.condition = "And";
        NextObj.checks.add(and);
        return this;
    }
    public Check orRule(Check nextCheck)
    {
        or = nextCheck;
        or.condition = "Or";
        NextObj.checks.add(or);
        return this;
    }

    public String getCondition() {
        return condition;
    }

    public Check getAnd() {
        return and;
    }

    public Check getOr() {
        return or;
    }
}

