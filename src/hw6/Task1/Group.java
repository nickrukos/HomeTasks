package hw6.Task1;

import java.util.ArrayList;

public class Group
{
    private  ArrayList <Alpinist> alpinists;
    private Mountain mountain;
    private int alpinCount;  //число альпинистов в группе

    public String addAlpinist(Alpinist alpinist)
    {
        if (this.alpinists.size() < alpinCount)
        {
            this.alpinists.add(alpinist);
            return "Альпинист добавлен";
        }
        return "Извините, группа уже сформирована";
    }
    public Group(Mountain mountain, int alpinCount)
    {
        this.mountain = mountain;
        this.alpinCount = alpinCount;
        this.alpinists = new ArrayList<Alpinist>();
    }
}
