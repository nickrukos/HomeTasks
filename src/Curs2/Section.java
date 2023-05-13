package Curs2;

import java.util.HashMap;

public class Section
{
    private  String title;
    private  String text;
    private String number;
    private HashMap<String,String> nextSections;
    public Section ()
    {
        nextSections = new HashMap<>();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setNextSection(String key, String str)
    {
        nextSections.put(key,str);
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getNumber() {
        return number;
    }

    public HashMap<String, String> getNextSections() {
        return nextSections;
    }
}
