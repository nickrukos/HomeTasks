package hw8;

import java.util.Locale;

public class Delimiter extends AppLogger
{
    AppLogger logger;

    public Delimiter(AppFileWriter fileWriter)
    {
        if(fileWriter == null)
        {
            throw new IllegalArgumentException("Error in creating AppFileWriter object");
        }
        logger = (AppLogger) fileWriter;
    }
    public Delimiter(ConsoleWriter consoleWriter)
    {
        if(consoleWriter == null)
        {
            throw new IllegalArgumentException("Error in creating ConsoleWriter object");
        }
        logger = (AppLogger) consoleWriter;
    }
    public Delimiter(Upper upper)
    {
        if( upper == null)
        {
            throw new IllegalArgumentException("Error in creating Upper object");
        }
        logger = (AppLogger) upper;
    }
    @Override
    public void log(String str)
    {
        str = "===" + str + "===";
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
        if (logger instanceof Upper)
        {
            ((Upper)logger).log(str);
            return;
        }
    }
}
