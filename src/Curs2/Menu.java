package Curs2;

import java.util.ArrayList;
import java.util.List;

public class Menu
{
    private List<IMenuOperation> items;
    public Menu(int itemsCount)
    {
        items = new ArrayList<>();
        for (int i = 0; i < itemsCount; i++)
        {
            items.add(null);
        }
    }
    public void setItem(int button, IMenuOperation item)
    {
        items.set(button,item);
    }
    public void selectItem(int button)
    {
        items.get(button).execute();
    }
}
