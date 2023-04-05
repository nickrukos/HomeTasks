package hw8;

import java.util.Locale;

public class Upper extends AppLogger
{
    AppLogger logger;

    public Upper(AppFileWriter fileWriter)
    {
        if(fileWriter == null)
        {
            throw new IllegalArgumentException("Error in creating AppFileWriter object");
        }
        logger = (AppLogger) fileWriter;
    }
    public Upper(ConsoleWriter consoleWriter)
    {
        if(consoleWriter == null)
        {
            throw new IllegalArgumentException("Error in creating ConsoleWriter object");
        }
        logger = (AppLogger) consoleWriter;
    }
    public Upper(Delimiter delimiter)
    {
        if( delimiter == null)
        {
            throw new IllegalArgumentException("Error in creating Delimiter object");
        }
        logger = (AppLogger) delimiter;
    }
    @Override
    public void log(String str)
    {
        str = str.toUpperCase(Locale.ROOT);
        if(logger instanceof AppFileWriter)
        {
            AppFileWriter fileWriter = new AppFileWriter();
            fileWriter.log(str);
            return;
        }
        if(logger instanceof ConsoleWriter)
        {
            ConsoleWriter consoleWriter = new ConsoleWriter();
            consoleWriter.log(str);
            return;
        }
        if (logger instanceof Delimiter)
        {
            ((Delimiter)logger).log(str);
            return;
        }
    }

}
