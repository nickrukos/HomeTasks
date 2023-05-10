package Curs2;

public class StartGameOperation extends MenuOperation
{
    private MenuItems menuItem;
    public final String menuPoint = "Start Game";

    public StartGameOperation(String item,  MenuItems menuItem)
    {
        super(item);
        this.menuItem = menuItem;
    }

    @Override
    public void execute()
    {
        menuItem.startGame();
    }
}
