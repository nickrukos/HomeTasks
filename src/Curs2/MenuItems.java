package Curs2;

public class MenuItems
{
    public void startGame()
    {
        System.out.println("Start Game");
        Menu.gameMenu();
    }
    public void loadGame()
    {
        System.out.println("Load Game");
    }
    public void saveGame()
    {
        System.out.println("Save Game");
    }
    public void returnToMainMenu()
    {
        System.out.println("Return to Main Menu");
        Menu.mainMenu();
    }
    public void exitGame()
    {
        System.out.println("Game Over!");
        System.exit(0);
    }
}
