package hw8;

import java.util.Locale;

public class Upper extends AppDop implements AppLogger
{
    public Upper(AppLogger appLogger)
    {
        super(appLogger);
    }
    public void log(String str)
    {
        str = str.toUpperCase(Locale.ROOT);
        this.logger.log(str);
    }

}
