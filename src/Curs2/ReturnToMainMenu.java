package Curs2;

public class ReturnToMainMenu extends MenuOperation
{
    private MenuItems menuItem;
    public final String menuPoint = "Load Game";

    public ReturnToMainMenu(String item,  MenuItems menuItem)
    {
        super(item);
        this.menuItem = menuItem;
    }

    public void execute()
    {
        menuItem.returnToMainMenu();
    }
}
