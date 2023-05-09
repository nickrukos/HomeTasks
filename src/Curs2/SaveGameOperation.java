package Curs2;

public class SaveGameOperation implements IMenuOperation
{
    private MenuItems menuItem;
    public final String menuPoint = "Save Game";

    public SaveGameOperation(MenuItems menuItem) {
        this.menuItem = menuItem;
    }

    public void execute()
    {
        menuItem.saveGame();
    }
}
