package Curs2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MenuItems
{
    public void startGame()
    {
        Menu.gameMenu(0);
    }
    public void loadGame() throws IOException {
        BufferedReader reader = Files.newBufferedReader(Paths.get("src/curs2/save.txt"), StandardCharsets.UTF_8);
        String str = reader.readLine();
        if(str == null || str.trim().length() == 0)
        {
            System.out.println("There's no saved game yet");
            reader.close();
            return;
        }
        reader.close();
        Menu.gameMenu(Integer.parseInt(str));
    }
    public void saveGame() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("src/curs2/save.txt");
        String str = Game.getNumberSection();
        fileOutputStream.write(str.getBytes());
        fileOutputStream.close();
        Game.DrawSection(Integer.parseInt(str));
    }
    public void returnToMainMenu()  {
        System.out.println("Return to Main Menu");
        Menu.mainMenu();
    }
    public void exitGame()
    {
        System.out.println("Game Over!");
        System.exit(0);
    }
    public void loadFirstSection() {
        if(Game.getArrKey().get(0).equals("30") || Game.getArrKey().get(0).equals("-1")
            || Game.getArrKey().get(0).equals("40") || Game.getArrKey().get(0).equals("-2"))
        {

            returnToMainMenu();
            return;
        }
        String str = Game.getArrKey().get(0);
        str = str.substring(2);
        Game.DrawSection(Integer.parseInt(str)-1);
    }
    public void loadSecondSection()
    {
        String str = Game.getArrKey().get(1);
        str = str.substring(2);
        Game.DrawSection(Integer.parseInt(str)-1);
    }
    public void loginGame() throws IOException
    {
        System.out.println("Please type your login:");
        Scanner userValue = new Scanner(System.in);
        String userLogin = userValue.nextLine();
        System.out.println("Please type your password:");
        String userPassword = userValue.nextLine();
        String userCurrentSection = User.loadUser(userLogin,userPassword,"src/curs2/user.txt");
        if(userCurrentSection == null)
        {
            System.out.println("Your login or password is incorrect!");
            return;
        }
        User user = new User(userLogin,userPassword,Integer.parseInt(userCurrentSection));
    }
    public void registerUser() throws IOException
    {
        String userLogin;
        String userPassword;
        System.out.println("Please type your login or '1' to return to Menu:");
        Scanner userValue = new Scanner(System.in);
        userLogin = userValue.nextLine();
        System.out.println("Please type your password:");
        userPassword = userValue.nextLine();
        String userCurrentSection = User.loadUser(userLogin, userPassword, "src/curs2/user.txt");
        if (userCurrentSection != null)
        {
            System.out.println("This user has present in the game! Try once more!");
            return;
        }

        User user = new User(userLogin,userPassword,1);
    }
}
