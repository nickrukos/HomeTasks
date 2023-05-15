package Curs2;

public class LoadRightSectionOperation extends MenuOperation
{
    private MenuItems menuItem;
    public LoadRightSectionOperation(String item,  MenuItems menuItem)
    {
        super(item);
        this.menuItem = menuItem;
    }
    public void execute()
    {
        menuItem.loadRightSection();
    }
}
