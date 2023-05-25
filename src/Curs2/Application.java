package Curs2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Application
{

    public static void main(String[] args)
    {
       User user = new User();
       user.userMenu();
       Game.setSections("src/Curs2/file.txt");

    }
}
