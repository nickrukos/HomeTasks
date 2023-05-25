package Curs2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.RandomAccess;
import java.util.Scanner;

public class User
{
    private String login;
    private String password;
    private int currentSection;

    public static String loadUser(String login, String password, String fileName) throws IOException
    {
        RandomAccessFile file = new RandomAccessFile(fileName,"rw");
        file.seek(0);
        String record = null;
        while((record = file.readLine()) != null)
        {
            String[] words = record.split(";");
            if(words[0].equals(login) && words[1].equals(password))  return record;
        }
        file.close();
        return null;
    }
    public void saveUser(String fileName) throws IOException
    {
        RandomAccessFile file = new RandomAccessFile(fileName,"rw");
        String record = this.login + ";" + this.password + ";" + this.currentSection;
        String fileRecord = null;
        file.seek(0);
        while((fileRecord = file.readLine()) != null)
        {
            file.seek((long)fileRecord.length());
            String[] words = fileRecord.split(";");
            if(words[0].equals(login) && words[1].equals(password)) break;
        }
        file.writeChars(record);
        file.close();
    }
    public void userMenu()
    {
        MenuItems menuItems = new MenuItems();
        Menu userMenu = new Menu(3);
        LoginUserOperation loginUser = new LoginUserOperation("Login User",menuItems);
        RegisterUserOperation registerUser = new RegisterUserOperation("Register User", menuItems);
        userMenu.setItem(1,loginUser);
        userMenu.setItem(2,registerUser);
        userMenu.setItem(3,new ExitGameOperation("Exit Game",menuItems));
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
                if(loginUser.getLogin() != null)
                {
                    Game.setCurrentLogin(loginUser.getLogin());
                    Game.setCurrentPassword(loginUser.getPassword());
                    Game.setNumberSection(Integer.parseInt(loginUser.getCurrentSection()-1);
                    Menu.mainMenu();
                }
                System.out.println("Your login or password is incorrect!");
            }
            if(userAnswer == 2)
            {
                //register user
                if(registerUser.getLogin() != null)
                {
                    this.login = registerUser.getLogin();
                    this.password = registerUser.getPassword();
                    this.currentSection = Integer.parseInt(registerUser.getCurrentSection());
                    Menu.mainMenu();
                }
                System.out.println("This user has present in the game! Try login or change login and password!");
            }
        }
    }


    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getCurrentSection() {
        return currentSection;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCurrentSection(int currentSection) {
        this.currentSection = currentSection;
    }
}
