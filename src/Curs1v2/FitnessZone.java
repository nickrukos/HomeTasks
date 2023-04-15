package Curs1v2;

public enum FitnessZone
{
    POOL ("Pool area"), TRAINEGER ("Traineger area"), GROUP ("Group training");
    public final String title;

    FitnessZone(String str)
    {
        this.title = str;
    }
}
