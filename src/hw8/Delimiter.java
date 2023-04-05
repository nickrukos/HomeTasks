package hw8;

import java.util.Locale;

public class Delimiter extends AppDop implements AppLogger
{
    public Delimiter(AppLogger appLogger)
    {

        super(appLogger);
    }
    @Override
    public void log(String str)
    {
        str = "===" + str + "===";
        this.logger.log(str);
    }
}
