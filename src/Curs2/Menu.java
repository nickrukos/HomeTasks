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
        startMenu.setItem(2,new ReturnToUserMenuOperation("Return to User Menu",  menuItems));
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
        SaveGameOperation saveGame = new SaveGameOperation("SaveGame",  menuItems);
        ReturnToMainMenu returnToMainMenu = new ReturnToMainMenu("Return to Main menu",  menuItems);
        gameMenu.setItem(0, saveGame);
        gameMenu.setItem(1, returnToMainMenu);
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

    public static void userMenu()
    {
        MenuItems menuItems = new MenuItems();
        Menu userMenu = new Menu(3);
        LoginUserOperation loginUser = new LoginUserOperation("Login User",menuItems);
        RegisterUserOperation registerUser = new RegisterUserOperation("Register User", menuItems);
        userMenu.setItem(0,loginUser);
        userMenu.setItem(1,registerUser);
        userMenu.setItem(2,new ExitGameOperation("Exit Game",menuItems));
        userMenu.Draw(3);
        while (true)
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
            userMenu.getItem(userAnswer-1).execute();
            if(userAnswer == 1)
            {
                //login user
                if(Game.getCurrentLogin() != null)
                {
                    Menu.mainMenu();
                }
                System.out.println("Your login or password is incorrect, or you haven't saved Game, or you typed '1'!");
            }
            if(userAnswer == 2)
            {
                //register user
                if(Game.getCurrentLogin() != null)
                {
                    Menu.mainMenu();
                }
                System.out.println("This user has present in the game! Try login or change login and password! \n Or you typed '1'");
            }
        }
    }

    public static void sectionMenu()
    {
        MenuItems menuItems = new MenuItems();
        Menu sectionMenu = new Menu(2);
    }

}
