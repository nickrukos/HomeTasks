package Curs2;

public class ExitGameOperation extends MenuOperation
{
    private MenuItems menuItem;

    public ExitGameOperation(String item,MenuItems menuItem)
    {
        super(item);
        this.menuItem = menuItem;
    }
    public void execute()
    {
         menuItem.exitGame();
    }
}
