package Curs2;

public class LoadGameOperation extends MenuOperation
{
    private MenuItems menuItem;

    public LoadGameOperation(String item,  MenuItems menuItem)
    {
        super(item);
        this.menuItem = menuItem;
    }

    public void execute()
    {
        menuItem.loadGame();
    }
}
