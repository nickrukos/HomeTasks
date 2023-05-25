package Curs2;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SaveGameOperation extends MenuOperation
{
    private String login;
    private String password;
    private String currentSection;
    private MenuItems menuItem;

    public SaveGameOperation(String item,  MenuItems menuItem)
    {
        super(item);
        this.menuItem = menuItem;
    }

    public void execute()
    {
        try {
            menuItem.saveGame();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCurrentSection(String currentSection) {
        this.currentSection = currentSection;
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
