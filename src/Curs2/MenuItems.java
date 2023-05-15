package Curs2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MenuItems
{
    public void startGame()
    {
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
    public void loadLeftSection()
    {
        if(Game.getArrKey().get(0).equals("30") || Game.getArrKey().get(0).equals("-1")
            || Game.getArrKey().get(0).equals("40") || Game.getArrKey().get(0).equals("-2"))
        {

            returnToMainMenu();
            return;
        }
        Game.DrawSection(Integer.parseInt(Game.getArrKey().get(0)));
    }
    public void loadRightSection()
    {
        Game.DrawSection(Integer.parseInt(Game.getArrKey().get(1)));
    }
}
