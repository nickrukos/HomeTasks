package hw15.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task02 {


    public static void main(String[] args) {
        // Задания по классу Course из пакета package ru.itmo.lessons.lesson18.task

        Course course01 = new Course("math",1,10);
        Course course02 = new Course("it",2,30);
        Course course03 = new Course("it",2,10);
        Course course04 = new Course("law",3,40);
        Course course05 = new Course("economy",2,30);
        Course course06 = new Course("math",3,40);
        Stream<Course> courses = Stream.of(course01,course02,course03,course04,course05,course06);
        // TODO 1: Создать map,
        //  где ключи - названия курсов,
        //  значения - списки курсов с указанным в ключе названием
        Map<String, List<Course>> names = courses
                .collect(Collectors.groupingBy(course -> course.getName(),Collectors.toCollection(ArrayList::new)));

        // TODO 2: Создать map,
        //  где ключи - продолжительность курсов,
        //  значения - списки курсов с указанной в ключе продолжительностью
        Map<Integer, List<Course>> durations = courses.collect(Collectors.groupingBy(course -> course.getDuration()));

        // TODO 3: Создать map, где ключи - названия курсов,
        //  значения - количество курсов с указанным в ключе названием
        Map<String,Long> counts = courses.collect(Collectors.groupingBy(course -> course.getName(),Collectors.counting()));

        // TODO 4: Создать map, где ключи - названия курсов,
        //  значения - map,
        //  в которой  ключи - продолжительность курса,
        //  а значения - списки курсов с указанной в ключе продолжительностью
        Map<String,Map<Integer,List<Course>>> map01 =
            courses.collect(Collectors.groupingBy(course -> course.getName(),
                    Collectors.groupingBy(course -> course.getDuration(),
                            Collectors.toCollection(ArrayList::new))));
    }
}