package hw14.task1;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Task01 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(1, "����", Student.Gender.MALE, LocalDate.now().minusYears(10)),
                new Student(2, "����", Student.Gender.MALE, LocalDate.now().minusYears(7)),
                new Student(3, "�����", Student.Gender.FEMALE, LocalDate.now().minusYears(6)),
                new Student(4, "����", Student.Gender.MALE, LocalDate.now().minusYears(12)),
                new Student(5, "�������", Student.Gender.MALE, LocalDate.now().minusYears(9)),
                new Student(6, "����", Student.Gender.MALE, LocalDate.now().minusYears(9)),
                new Student(7, "����", Student.Gender.MALE, LocalDate.now().minusYears(17)),
                new Student(8, "����", Student.Gender.MALE, LocalDate.now().minusYears(5)),
                new Student(9, "�����", Student.Gender.FEMALE, LocalDate.now().minusYears(8)),
                new Student(10, "�����", Student.Gender.FEMALE, LocalDate.now().minusYears(10)),
                new Student(11, "��������", Student.Gender.MALE, LocalDate.now().minusYears(7)),
                new Student(12, "�����", Student.Gender.FEMALE, LocalDate.now().minusYears(6))
        ));

        // TODO: ��������� ������ Stream API:
        //  1. ��������� �������� �� ��� ������: ��������� � �������. ���������: Map<Student.Gender, ArrayList<Student>>
        //  2. ����� ������� ������� ��������
        //  3. ����� ������ �������� �������
        //  4. ����� ������ �������� �������
        //  5. ������� �������� � ������ �� ���� ��������
        //  6. ������������� �� ����, ����� �� ���� ��������, ����� �� ����� (� �������� �������), ������� � ������ (ArrayList)
        //  7. ������� � ������� ���� �������� � �������� �� N �� M ���
        //  8. ������� � ������ ���� �������� � ������=someName
        //  9. ������� Map<Student.Gender, Integer>, ��� Student.Gender - ���, Integer - ��������� ������� �������� ������� ����
        //     ��. ����� Collectors.summingInt
        Map<Student.Gender, List<Student>> genderStudents = students.stream().collect(Collectors.groupingBy(student->student.getGender()));

    }
}
