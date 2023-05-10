package Curs2;

public class Application
{

    public static void main(String[] args)
    {
        MenuItems menuItems = new MenuItems();
        Menu startMenu = new Menu(3);
        startMenu.setItem(0,new StartGameOperation("StartGame",  menuItems));
        startMenu.setItem(1, new LoadGameOperation( "LoadGame",  menuItems));
        startMenu.setItem(2,new ExitGameOperation("ExitGame",  menuItems));

        Menu extendMenu = new Menu(2);
        extendMenu.setItem(0, new SaveGameOperation("SaveGame",  menuItems));
        extendMenu.setItem(1, new ReturnToMainMenu("Return to Main menu",  menuItems));

        System.out.println("Welcome to our Forest!");
        startMenu.Draw();
    }
}
