package Curs2;

public class LoadFirstSectionOperation extends MenuOperation
{
    private MenuItems menuItem;
    public LoadFirstSectionOperation(String item, MenuItems menuItem)
    {
        super(item);
        this.menuItem = menuItem;
    }
    public void execute()
    {
        menuItem.loadFirstSection();
    }
}
