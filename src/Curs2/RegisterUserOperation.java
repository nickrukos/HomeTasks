package Curs2;

import java.io.IOException;

public class RegisterUserOperation extends MenuOperation
{
    private String login;
    private String password;
    private String currentSection;
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
        if(userCurrent != null)
        {
            String[] words = userCurrent.split(";");
            login = words[0];
            password = words[1];
            currentSection = words[2];
        }
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getCurrentSection() {
        return currentSection;
    }
}
