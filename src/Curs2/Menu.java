package Curs2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    public void Draw(int size)
    {
        for (int i = 0; i < size; i++) {
            System.out.println((i+1) + " " + items.get(i).item_name);
        }
    }
    public static void mainMenu()  {
        MenuItems menuItems = new MenuItems();
        Menu startMenu = new Menu(3);
        startMenu.setItem(0,new StartGameOperation("StartGame",  menuItems));
        startMenu.setItem(1, new LoadGameOperation( "LoadGame",  menuItems));
        startMenu.setItem(2,new ExitGameOperation("ExitGame",  menuItems));
        startMenu.Draw(3);
        while(true)
        {
            Scanner userValue = new Scanner(System.in);
            System.out.println("Press from 1 to 3 for your choice");
            int userAnswer = userValue.nextInt();
            if(!(userAnswer == 1 || userAnswer == 2
                    || userAnswer == 3))
            {
                System.out.println("You pressed a wrong key!");
                continue;
            }
            startMenu.getItem(userAnswer-1).execute();
        }
    }
    public static void gameMenu(int index)
    {
        MenuItems menuItems = new MenuItems();
        Menu gameMenu = new Menu(4);
        gameMenu.setItem(0, new SaveGameOperation("SaveGame",  menuItems));
        gameMenu.setItem(1, new ReturnToMainMenu("Return to Main menu",  menuItems));
        gameMenu.setItem(2,new LoadFirstSectionOperation("",menuItems));
        gameMenu.setItem(3,new LoadSecondSectionOperation("",menuItems));
        gameMenu.Draw(2);
        Game.DrawSection(index);
        while(true)
        {
            Scanner userValue = new Scanner(System.in);
            int userAnswer = userValue.nextInt();
            if(!(userAnswer == 1 || userAnswer == 2
                 || userAnswer == 3 || userAnswer == 4))
            {
                System.out.println("You pressed a wrong key!");
                continue;
            }
            gameMenu.getItem(userAnswer-1).execute();
        }
    }
    public static void sectionMenu()
    {
        MenuItems menuItems = new MenuItems();
        Menu sectionMenu = new Menu(2);
    }
}
