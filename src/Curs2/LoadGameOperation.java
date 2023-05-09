package Curs2;

public class LoadGameOperation implements IMenuOperation
{
    private MenuItems menuItem;
    public final String menuPoint = "Load Game";

    public LoadGameOperation(MenuItems menuItem) {
        this.menuItem = menuItem;
    }

    public void execute()
    {
        menuItem.loadGame();
    }
}
