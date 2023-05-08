package hw15.task7;

public class task07
{
    public static void main(String[] args) {
        String fileName = "d:\\br.xml";
        FileStorage storage = new FileStorage(new RuleXML().orRule(new RuleJson()).orRule(new RuleXls()));
        if (storage.addFile(fileName)) System.out.println("File is added");
        else System.out.println("File isn't added");
        fileName = "\\pl.xls";
        if (storage.addFile(fileName)) System.out.println("File is added");
        else System.out.println("File isn't added");
    }
}
