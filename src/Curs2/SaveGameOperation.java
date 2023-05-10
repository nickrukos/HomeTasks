package Curs2;

public class SaveGameOperation extends MenuOperation
{
    private MenuItems menuItem;

    public SaveGameOperation(String item,  MenuItems menuItem)
    {
        super(item);
        this.menuItem = menuItem;
    }

    public void execute()
    {
        menuItem.saveGame();
    }
}
