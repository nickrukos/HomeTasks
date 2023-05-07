package hw15.task6;

abstract public class Check
{
    private boolean result;
    private boolean condition;
    private Check nextCheck;
    protected String fileName;
    abstract boolean checkRule();
    public Check addRule(Check nextCheck)
    {
        this.nextCheck = nextCheck;
        if(checkRule() && nextCheck.checkRule()) this.condition = true;
        else this.condition = false;
        return this;
    }
    public Check orRule(Check nextCheck)
    {
        this.nextCheck = nextCheck;
        if(checkRule() || nextCheck.checkRule()) this.condition = true;
        else this.condition = false;
        return this;
    }
    public void doCheck()
    {
        result = checkRule();
        if(nextCheck != null)
        {
            result = condition;
            return;
        }
    }
    public Check (String fileName)
    {
        this.fileName = fileName;
    }

    public boolean isResult() {
        return result;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
