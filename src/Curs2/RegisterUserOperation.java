package Curs2;

import java.io.IOException;

public class RegisterUserOperation extends MenuOperation
{
    private MenuItems menuItem;
    public final String menuPoint = "Register User";
    public RegisterUserOperation(String item,  MenuItems menuItem)
    {
       super(item);
       this.menuItem = menuItem;
    }
    public void execute()
    {
        String userCurrent = null;
        try {
            userCurrent = menuItem.registerUser();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
