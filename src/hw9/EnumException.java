package hw9;

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.jar.JarException;

public class EnumException extends Exception
{
    public EnumException(String message)
    {
        super(message);
    }
    public EnumException(String message, Throwable cause)
    {
        super(message,cause);
    }
    public EnumException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getMessage()
    {
        return "��� ������" + super.getMessage();
    }

    public static void throwException(Status status) throws FileNotFoundException, AccessDeniedException,JarException
    {
        switch (status)
        {
            case FILE_NOT_FOUND:
                throw new FileNotFoundException("������ FileNotFound");
            case ACCESS_DENIED:
                throw new AccessDeniedException("������ AccessDenied");
            case JAR_ERROR:
                throw new JarException("������ JAR_ERROR");
        }
    }
}
