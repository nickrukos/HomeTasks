package Curs2;

public class ExitGameOperation implements IMenuOperation
{
    private MenuItems menuItem;
    public final String menuPoint = "Exit Game";
    public ExitGameOperation(MenuItems menuItem)
    {
        this.menuItem = menuItem;
    }
    public void execute()
    {
        menuItem.exitGame();
    }
}
