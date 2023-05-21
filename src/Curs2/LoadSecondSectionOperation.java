package Curs2;

public class LoadSecondSectionOperation extends MenuOperation
{
    private MenuItems menuItem;
    public LoadSecondSectionOperation(String item, MenuItems menuItem)
    {
        super(item);
        this.menuItem = menuItem;
    }
    public void execute()
    {
        menuItem.loadSecondSection();
    }
}
