package hw13;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class University {
    private List<Course> courses = new ArrayList<>();

    public boolean addCourse(Course course) {
        return courses.add(Objects.requireNonNull(course));
    }
    public boolean addCourses(List<Course> courses) {
        return this.courses.addAll(Objects.requireNonNull(courses));
    }

    public void upPrice(double newPrice, double currentPrice) {
        // метод увеличивает стоимость курсов (courses) на newPrice,
        // если текуща€ стоимость меньше currentPrice
        // использовать метод foreach коллекций
        Predicate<Double> price = priceCourse -> priceCourse < currentPrice;
        Consumer<Course> incrPrice = course -> {
            if(price.test(course.getPrice())) course.setPrice(course.getPrice() + newPrice);
        };
        courses.forEach(incrPrice);
    }
    Comparator<Course> compareByPrice = (course1,course2) -> (int) (course2.getPrice() - course1.getPrice());
    Comparator<Course> compareByDuration = (course1,course2) -> (int) (course2.getDuration() - course1.getDuration());
    public void sortByDurationAndPrice(Comparator<Course> comparator) {
        // метод сортирует коллекцию courses по стоимости,
        // если курсы одинаковы по стоимости, сортирует по продолжительности
        if(comparator == null) throw new IllegalArgumentException("Comparator is Null");
        comparator = compareByPrice.thenComparing(compareByDuration);
        courses.sort(comparator);
    }

    public void upDuration(double currentPrice) {
        // метод увеличивает продолжительность курсов (courses) на 1,
        // если их стоимость больше currentPrice
        // использовать метод foreach коллекций
        Predicate<Double> price = priceCourse -> priceCourse > currentPrice;
        Consumer<Course> incrDuration = course -> {
            if(price.test(course.getPrice())) course.setDuration(course.getDuration() + 1);
        };
        courses.forEach(incrDuration);
    }
    public void deleteName(String name)  //ƒ« п. 1
    {
        Predicate<Course> delName = course -> course.getName().equals(name);
        courses.removeIf(delName);
    }
    public void deleteDurationAndPrice(double duration, double price) //ƒ« п. 2
    {
        Predicate <Course> delPriceAndDuration = course -> course.getDuration() < duration
                                                  && course.getPrice() < price;
        courses.removeIf(delPriceAndDuration);
    }
    public String funcIntStr(double price)   //ƒ« п. 3
    {
        Function<Double,String> printPrice = (value) -> String.valueOf(value) + " р.";
        return printPrice.apply(price);
    }
}