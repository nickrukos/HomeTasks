package hw14.task2;

//import ru.itmo.lessons.lesson14.task2.Fruit;

import java.util.Optional;

public class Lesson19Optional {
    public static void main(String[] args) {
        String name = "Tom";

        // создание объекта
        Optional<String> optional01 = Optional.of(name); // если name == null,
        // будет выброшено исключение

        Optional<String> optional02 = Optional.ofNullable(name); // если name == null,
        // будет создан контейнер с null ссылкой

        Optional<String> optional03 = Optional.empty(); // создает контейнер с null ссылкой

        // проверка
        if (optional02.isEmpty()) {
            System.out.println("Контейнер содержит null ссылку");
        }

        if (optional02.isPresent()) {
            System.out.println("Контейнер не содержит null ссылку");
        }

        // получение значений или новых Optional
        String get = optional02.get(); // если контейнер содержит null ссылку,
        // будет выброшено исключение

        String orElse = optional02.orElse("default"); // если контейнер содержит null ссылку,
        // метод вернет значение по-умолчанию. Объект переданный в метод будет создан

        String orElseGet = optional02.orElseGet(() -> "default"); // если контейнер содержит null ссылку,
        // метод вернет значение по-умолчанию. Объект переданный в метод не будет создан

        Optional<String> filter = optional02.filter(value -> value.length() < 10);
        // filter(Predicate) вернет Optional со ссылкой на значение из optional02,
        // если оно соответствует условию value.length() < 10,
        // в противном случае вернет Optional с null ссылкой

        Optional<Integer> map = optional02.map(value -> value.length());
        // map(Function) - вернет Optional со значением, которое возвращает метод apply экземпляра Function
        // или контейнер с null ссылкой, если optional02 содержал null ссылку

        int percent = 10;
        Optional<Number> numberOptional = Optional.ofNullable(percent);
        Optional<Number> or = numberOptional.or(() -> Optional.of(1.1));
        // or(Supplier<? extends Optional<? extends T>> supplier) - вернет Optional со значением numberOptional
        // или новый Optional контейнер

        // ifPresent(Consumer) выполнится, если optional02 не содержит null ссылку
        optional02.ifPresent(value -> System.out.println(value.toUpperCase()));

        // ifPresentOrElse(Consumer, Runnable)
        optional02.ifPresentOrElse(
              // выполнится, если optional02 не содержит null ссылку
               value -> System.out.println(value.toUpperCase()),
               // выполнится, если optional02 содержит null ссылку
                () -> System.out.println("Значения не существует")
        );

    }




}
