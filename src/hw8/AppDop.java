package hw8;

abstract public class AppDop implements AppLogger
{
    protected AppLogger logger;
    public AppDop(AppLogger appLogger)
    {
        if(appLogger == null)
        {
            throw new IllegalArgumentException("Error creating object");
        }
        this.logger = appLogger;
    }
    abstract public void log(String str);
}
