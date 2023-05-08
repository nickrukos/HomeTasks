package hw15.task6;

public class task06
{
    public static void main(String[] args) {
        String fileName = "d:\\br.xls";
        Check check = new RuleXML(fileName).orRule(new RuleJson(fileName))
                .orRule(new RuleXls(fileName));
        FileStorage storage = new FileStorage(check);
        if (storage.addFile(fileName)) System.out.println("File is added");
        fileName = "\\pl.doc";
        check.doCheck(fileName);
        storage.setCheck(check);
        if (storage.addFile(fileName)) System.out.println("File is added");
    }
}
