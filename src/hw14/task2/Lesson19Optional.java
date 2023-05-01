package hw14.task2;

//import ru.itmo.lessons.lesson14.task2.Fruit;

import java.util.Optional;

public class Lesson19Optional {
    public static void main(String[] args) {
        String name = "Tom";

        // �������� �������
        Optional<String> optional01 = Optional.of(name); // ���� name == null,
        // ����� ��������� ����������

        Optional<String> optional02 = Optional.ofNullable(name); // ���� name == null,
        // ����� ������ ��������� � null �������

        Optional<String> optional03 = Optional.empty(); // ������� ��������� � null �������

        // ��������
        if (optional02.isEmpty()) {
            System.out.println("��������� �������� null ������");
        }

        if (optional02.isPresent()) {
            System.out.println("��������� �� �������� null ������");
        }

        // ��������� �������� ��� ����� Optional
        String get = optional02.get(); // ���� ��������� �������� null ������,
        // ����� ��������� ����������

        String orElse = optional02.orElse("default"); // ���� ��������� �������� null ������,
        // ����� ������ �������� ��-���������. ������ ���������� � ����� ����� ������

        String orElseGet = optional02.orElseGet(() -> "default"); // ���� ��������� �������� null ������,
        // ����� ������ �������� ��-���������. ������ ���������� � ����� �� ����� ������

        Optional<String> filter = optional02.filter(value -> value.length() < 10);
        // filter(Predicate) ������ Optional �� ������� �� �������� �� optional02,
        // ���� ��� ������������� ������� value.length() < 10,
        // � ��������� ������ ������ Optional � null �������

        Optional<Integer> map = optional02.map(value -> value.length());
        // map(Function) - ������ Optional �� ���������, ������� ���������� ����� apply ���������� Function
        // ��� ��������� � null �������, ���� optional02 �������� null ������

        int percent = 10;
        Optional<Number> numberOptional = Optional.ofNullable(percent);
        Optional<Number> or = numberOptional.or(() -> Optional.of(1.1));
        // or(Supplier<? extends Optional<? extends T>> supplier) - ������ Optional �� ��������� numberOptional
        // ��� ����� Optional ���������

        // ifPresent(Consumer) ����������, ���� optional02 �� �������� null ������
        optional02.ifPresent(value -> System.out.println(value.toUpperCase()));

        // ifPresentOrElse(Consumer, Runnable)
        optional02.ifPresentOrElse(
              // ����������, ���� optional02 �� �������� null ������
               value -> System.out.println(value.toUpperCase()),
               // ����������, ���� optional02 �������� null ������
                () -> System.out.println("�������� �� ����������")
        );

    }




}
