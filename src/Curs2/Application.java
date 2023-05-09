package Curs2;

public class Application
{
    public static void main(String[] args)
    {
        MenuItems menuItems = new MenuItems();
        Menu startMenu = new Menu(3);
        startMenu.setItem(0,new StartGameOperation(menuItems));
        startMenu.setItem(1, new LoadGameOperation(menuItems));
        startMenu.setItem(2,new ExitGameOperation(menuItems));

        Menu extendMenu = new Menu(2);
        extendMenu.setItem(0, new SaveGameOperation(menuItems));
        extendMenu.setItem(1, new ReturnToMainMenu(menuItems));
    }
}
