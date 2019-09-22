package com.epam.education.introduction.task5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Thread.sleep;

public class Main {
    private static volatile List<String> listThreadMain = new ArrayList<>();
    private static volatile List<String> listThreadDemon = new ArrayList<>();

    public static void main(String[] args) {
        //Demo thread
        Thread threadDemo = new Thread(
                () -> Stream.iterate(1, x->x+1)
                        .limit(1000)
                        .forEach((x)-> {
                            try {
                                sleep(100);
                                Stream.iterate(1, y->y+1)
                                        .limit(1000)
                                        .forEach((y) -> {
                                            listThreadDemon.add("thread demon" + y);
                                            listThreadMain.add("thread main" + y);
                                        });
                                System.out.println("Thread demon ready!" + x);
                                System.out.println("Thread demon in main ready!" + x);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }));
        threadDemo.start();

        //Main thread
        Stream.iterate(1, x->x+1)
                .limit(1000)
                .forEach((x)-> {
                    try {
                        sleep(100);
                        Stream.iterate(1, y->y+1)
                                .limit(1000)
                                .forEach((y) -> listThreadMain.add("thread main" + y));
                        System.out.println("Thread main ready!" + x);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }
}
