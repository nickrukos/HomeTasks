package Curs2;

import java.util.ArrayList;
import java.util.List;

public class Menu
{
    private List<MenuOperation> items;
    public Menu(int itemsCount)
    {
        items = new ArrayList<>();
        for (int i = 0; i < itemsCount; i++)
        {
            items.add(null);
        }
    }
    public void setItem(int button, MenuOperation item)
    {
        items.set(button,item);
    }
    public void selectItem(int button)
    {
        items.get(button).execute();
    }
    public MenuOperation getItem(int button)
    {
        return items.get(button);
    }
    public int getMenuSize()
    {
        return items.size();
    }
    public void Draw()
    {
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i+1) + " " + items.get(i).item_name);
        }
    }
}
