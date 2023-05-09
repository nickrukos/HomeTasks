package Curs2;

public class OpenTextFileOperation implements TextFileOperation
{
    public OpenTextFileOperation(TextFile textFile) {
        this.textFile = textFile;
    }

    private TextFile textFile;
    @Override
    public String execute() {
        return textFile.open();
    }
}