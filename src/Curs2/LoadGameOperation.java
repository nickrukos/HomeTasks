package Curs2;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadGameOperation extends MenuOperation
{
    private MenuItems menuItem;

    public LoadGameOperation(String item,  MenuItems menuItem)
    {
        super(item);
        this.menuItem = menuItem;
    }

    public void execute()
    {
        try {
            menuItem.loadGame();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
