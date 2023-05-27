package Curs2;

import java.io.IOException;

public class LoginUserOperation  extends MenuOperation
{
    private MenuItems menuItem;
    public final String menuPoint = "Login User";
    public LoginUserOperation(String item,  MenuItems menuItem)
    {
        super(item);
        this.menuItem = menuItem;
    }
    public void execute()
    {
        String userCurrent = null;
        try {
            userCurrent = menuItem.loginGame();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
