package com.epam.zhelezov.runnable.task3;

import com.epam.zhelezov.runnable.Person;

import java.util.Scanner;
import java.util.function.*;

public class MainTask3 {
    public static void main(String[] args) {
        Predicate<Integer> isPositive = x -> x > 0;
        BinaryOperator<Integer> multiply = (x, y) -> x * y * 3 / 2;
        UnaryOperator<Integer> square = x -> x * x * 2 + 36;
        Function<Integer, String> convert = x-> x + " Age";
        Consumer<Integer> printer = String::valueOf;
        Supplier<Person> userFactory = ()-> {
            Scanner in = new Scanner(System.in);
            System.out.println("Name : ");
            String name = in.nextLine();
            System.out.println("Age : ");
            Integer age = in.nextInt();
            return new Person(name, age);
        };
    }
}
