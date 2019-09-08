package com.epam.zhelezov.runnable;



import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class MainTask2 {

    public static void main(String[] args) {
        List<Person> people = getPersons();
        Comparator<Person> comparatorByName = Comparator.comparing(Person::getName);
        Comparator<Person> comparatorByAge = Comparator.comparing(Person::getAge);
        people.stream()
                .sorted(comparatorByName)
                .forEach(e -> System.out.print(e.toString() + "; "));
        System.out.println();
        people.stream()
                .sorted(comparatorByAge)
                .forEach(e -> System.out.print(e.toString() + "; "));
    }

    private static List<Person> getPersons() {
        return Arrays.asList(new Person("Vasya", 18), new Person("Oleg", 41),
                new Person("Dima", 43), new Person("Alexs", 48));
    }
}
