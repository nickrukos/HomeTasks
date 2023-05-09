package Curs2;

public class TextFile
{
    public TextFile(String name) {
        this.name = name;
    }

    private String name;
    public String open() {
        return "Opening file " + name;
    }
    public String save() {
        return "Saving file " + name;
    }
}