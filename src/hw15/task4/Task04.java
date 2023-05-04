package hw15.task4;

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
        Rule1 rule1 = new Rule1();
        Rule2 rule2 = new Rule2();
        Predicate<CheckFile> pr1 = checkFile -> rule1.rule(checkFile);
        Predicate<CheckFile> pr2 = checkFile -> rule2.rule(checkFile);
        Predicate<CheckFile> pr = pr1.and(pr2);


    }
}
