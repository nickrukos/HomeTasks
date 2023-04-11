package hw9;

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.jar.JarException;

public class Application
{
    public static void main(String[] args)
    {
        try {
            EnumException.throwException(Status.ACCESS_DENIED);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Ошибка времени выполнения");
        } catch (JarException e) {
            e.printStackTrace();
        }

        try {
            EnumException.throwException(Status.FILE_NOT_FOUND);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Ошибка времени выполнения");
        } catch (JarException e) {
            e.printStackTrace();
        }

        try {
            EnumException.throwException(Status.JAR_ERROR);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Ошибка времени выполнения");
        } catch (JarException e) {
            e.printStackTrace();
        }
    }
}
