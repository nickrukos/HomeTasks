package Curs2;

public class ReturnToMainMenu implements IMenuOperation
{
    private MenuItems menuItem;
    public final String menuPoint = "Load Game";

    public ReturnToMainMenu(MenuItems menuItem) {
        this.menuItem = menuItem;
    }

    public void execute()
    {
        menuItem.returnToMainMenu();
    }
}
