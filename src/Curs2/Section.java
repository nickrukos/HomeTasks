package Curs2;

public class Section
{
    private  String title;
    private  String text;
    private Integer number;
    private Integer[] nextSections = new Integer[2];
    public Section (int number)
    {
        this.number = number;
    }
}
