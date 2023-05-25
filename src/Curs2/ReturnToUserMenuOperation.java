package Curs2;

public class ReturnToUserMenuOperation extends MenuOperation
{
    private MenuItems menuItem;
    public final String menuPoint = "Return to User Menu";
    public ReturnToUserMenuOperation(String item,  MenuItems menuItem)
    {
        super(item);
        this.menuItem = menuItem;
    }
    public void execute()
    {
        menuItem.returnToUserMenu();
    }
}
