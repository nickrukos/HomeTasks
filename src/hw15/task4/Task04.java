package hw15.task4;

import java.io.File;
import java.util.function.Predicate;

public class Task04 {
    public static void main(String[] args) {
        // ������� FileStorage ������ ����� ������, ����� ������ �� ������ �������������.
        // ������� ��������� ����� ���� �������, �� ������ ���� ����������� �� ����������.
        // ��� �������� ���������� FileStorage ���������� ������ �� ������� ���������
        // (���� ��� ���������, ��������� � �������).
        // ������ ���� ����������� �������� ������� ���������.
        // ����� ����������� � FileStorage, ��� ����� ������ ��������� �������� �������� ������������� ����� ��������.
        // ���� ��� �� ������ ��������, ��� �� ����������� � ���������

        // FileStorage storage = new FileStorage(�������01.andRule(�������02.orRule(�������03)).andRule(�������04));
        // if (storage.addFile(filename)) System.out.println("���� ��������");
        // ��� ����� ����� ���������, ���� ��� ������ ��������:
        // ��������01 + ��������02 ��� ��������03 + ��������04

        // ����� �������� ���� �������������� ���������, ����� ��������� ���������,
        // ��� ������������ ���������� �� ������ java.util.function � ����������� � ��� ��������
         Predicate<CheckFile> pr1 = checkFile ->
        {
            File f = new File(checkFile.fileName);
            if(f.exists()) return true;
            return false;
        };
        Predicate<CheckFile> pr2 = checkFile ->
        {
            File f = new File(checkFile.fileName);
            if(checkFile.fileName.substring(checkFile.fileName.lastIndexOf('.')+1).equals("xml")) return true;
            return false;
        };
        Predicate<CheckFile> pr3 = checkFile ->
        {
            File f = new File(checkFile.fileName);
            if(checkFile.fileName.substring(checkFile.fileName.lastIndexOf('.')+1).equals("json")) return true;
            return false;
        };
        Predicate<CheckFile> pr = pr1.and(pr2.or(pr3));
        FileStorage fileStorage = new FileStorage(pr);
        String fileName = "D:\nick.xml";
        if (fileStorage.addFile(fileName)) System.out.println("File is added");
        else System.out.println("File doesn't exists");
    }
}
