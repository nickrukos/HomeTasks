package Curs2;

public class LoadLeftSectionOperation extends MenuOperation
{
    private MenuItems menuItem;
    public LoadLeftSectionOperation(String item,  MenuItems menuItem)
    {
        super(item);
        this.menuItem = menuItem;
    }
    public void execute()
    {
        menuItem.loadLeftSection();
    }
}
