package Curs2;

public class StartGameOperation implements IMenuOperation
{
    private MenuItems menuItem;
    public final String menuPoint = "Start Game";

    public StartGameOperation(MenuItems menuItem) {
        this.menuItem = menuItem;
    }

    @Override
    public void execute()
    {
        menuItem.startGame();
    }
}
