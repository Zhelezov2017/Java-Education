package com.epam.education.introduction.task3;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Thread.sleep;

public class Main {
    private static List<String> listMain = new LinkedList<>();

    public static void main(String[] args) {
        //Give OutOfMemoryError
        Stream.iterate(1, x -> x + 1)
                .limit(2000)
                .forEach((x) -> {
                    try {
                        sleep(250);
                        Stream.iterate(1, y -> y + 1)
                                .limit(2000)
                                .forEach((y) -> {
                                    listMain.add("Out of memory error" + y);
                                });
                        System.out.println("String downloading!" + x);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }
}
