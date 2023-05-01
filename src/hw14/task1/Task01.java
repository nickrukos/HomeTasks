package hw14.task1;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

class StudentAgeComparator implements Comparator<Student>
{
    public int compare(Student a, Student b)
    {
        LocalDate nw = LocalDate.now();
        Period diffA = Period.between(a.getBirth(),nw);
        Period diffB = Period.between(b.getBirth(),nw);
        return diffB.getYears() - diffA.getYears();
    }
}

class StudentAgeComparator2 implements Comparator<Student>
{
    public int compare(Student a, Student b)
    {
        return b.getBirth().compareTo(a.getBirth());
    }
}

class StudentGenderComparator implements Comparator<Student>
{
    public int compare(Student a, Student b)
    {
        if(a.getGender().equals(b.getGender())) return 0;
        if(a.getGender().equals(Student.Gender.FEMALE) && b.getGender().equals(Student.Gender.MALE)) return -1;
        return 1;
    }
}

class StudentNameComparator implements Comparator<Student>
{
    public int compare(Student a, Student b)
    {
        return a.getName().compareTo(b.getName());
    }
}

public class Task01 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(1, "Женя", Student.Gender.MALE, LocalDate.now().minusYears(10)),
                new Student(2, "Олег", Student.Gender.MALE, LocalDate.now().minusYears(7)),
                new Student(3, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(6)),
                new Student(4, "Иван", Student.Gender.MALE, LocalDate.now().minusYears(12)),
                new Student(5, "Алексей", Student.Gender.MALE, LocalDate.now().minusYears(9)),
                new Student(6, "Петр", Student.Gender.MALE, LocalDate.now().minusYears(9)),
                new Student(7, "Иван", Student.Gender.MALE, LocalDate.now().minusYears(17)),
                new Student(8, "Петр", Student.Gender.MALE, LocalDate.now().minusYears(5)),
                new Student(9, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(8)),
                new Student(10, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(10)),
                new Student(11, "Григорий", Student.Gender.MALE, LocalDate.now().minusYears(7)),
                new Student(12, "Ирина", Student.Gender.FEMALE, LocalDate.now().minusYears(6))
        ));

        // TODO: Используя методы Stream API:
        //  1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Student.Gender, ArrayList<Student>>
        //  2. Найти средний возраст учеников
        //  3. Найти самого младшего ученика
        //  4. Найти самого старшего ученика
        //  5. Собрать учеников в группы по году рождения
        //  6. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (ArrayList)
        //  7. Вывести в консоль всех учеников в возрасте от N до M лет
        //  8. Собрать в список всех учеников с именем=someName
        //  9. Собрать Map<Student.Gender, Integer>, где Student.Gender - пол, Integer - суммарный возраст учеников данного пола
        //     см. метод Collectors.summingInt
        //1
        Map<Student.Gender, List<Student>> genderStudents = students.stream()
                .collect(Collectors.groupingBy(student->student.getGender(),Collectors.toCollection(ArrayList::new)));
        //2
        double aveStudents = students.stream().mapToInt
                                   (s->{
                                          LocalDate nw = LocalDate.now();
                                          Period diff = Period.between(s.getBirth(), nw);
                                          Integer age = diff.getYears();
                                          return age;
                                       }
                                   ).average().getAsDouble();
        double aveStudents2 = students.stream().collect(Collectors
                                .averagingDouble(
                                                 s->{
                                                      LocalDate nw = LocalDate.now();
                                                      Period diff = Period.between(s.getBirth(), nw);
                                                      Integer age = diff.getYears();
                                                      return age;
                                                     }
                                                 ));
        //3
        Optional <Student> littleStudent = students.stream().min( new StudentAgeComparator());
        Student youngStudent = students.stream().min(new StudentAgeComparator2()).get();

        //4
        Optional <Student> oldStudent = students.stream().max(new StudentAgeComparator());

        //5
        Map<Integer,List<Student>> birthStudents = students.stream()
                .collect(Collectors.groupingBy(student -> student.getBirth().getYear()));

        //6
        students.sort(new StudentGenderComparator()
                      .thenComparing(new StudentAgeComparator2())
                      .thenComparing(new StudentNameComparator()));
        Collections.reverse(students);
        ArrayList<Student> sortedStudents = new ArrayList<>(students);

        students.stream().sorted(new StudentGenderComparator()
                .thenComparing(new StudentAgeComparator2())
                .thenComparing(new StudentNameComparator())
                .reversed())
                .collect(Collectors.toCollection(ArrayList::new));

        //7
        int N = 17;
        int M = 22;
        students.stream().filter(student -> {
                                                LocalDate nw = LocalDate.now();
                                                Period diff = Period.between(student.getBirth(), nw);
                                                Integer age = diff.getYears();
                                                if(age >= N && age <= M) return true;
                                                return false;
                                           }
                                )
                         .toList();

        //8
        String someName = "Алексей";
        students.stream().filter(student -> student.getName().equals(someName)).toList();

        //9
        Map<Student.Gender, Integer> mapSumAge = students.stream()
                                    .collect(Collectors
                                    .groupingBy
                                     (
                                      student -> student.getGender(),
                                      Collectors.summingInt(
                                                            student ->
                                                            {
                                                              LocalDate nw = LocalDate.now();
                                                              Period diff = Period.between(student.getBirth(), nw);
                                                              Integer age = diff.getYears();
                                                              return age;
                                                            }
                                                           )
                                      ));
    }
}
