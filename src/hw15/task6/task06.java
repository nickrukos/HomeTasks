package hw15.task6;

public class task06
{
    public static void main(String[] args) {
        String fileName = "d:\\br.xls";
        FileStorage storage = new FileStorage(new RuleXML(fileName).orRule(new RuleJson(fileName)));
        if (storage.addFile(fileName)) System.out.println("File is added");
    }
}
