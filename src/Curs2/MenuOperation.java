package Curs2;

public abstract class  MenuOperation
{
    protected final String item_name;
    public abstract void execute();
    public MenuOperation(String item)
    {
        this.item_name = item;
    }

}
