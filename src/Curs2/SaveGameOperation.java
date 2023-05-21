package Curs2;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SaveGameOperation extends MenuOperation
{
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
}
