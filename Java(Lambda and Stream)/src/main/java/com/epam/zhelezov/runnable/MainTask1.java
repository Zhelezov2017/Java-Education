package com.epam.zhelezov.runnable;


import java.util.stream.Stream;

import static java.lang.Thread.sleep;

public class MainTask1 {

    @SuppressWarnings("StreamToLoop")
    public static void main(String[] args) {
        Thread thread1 = new Thread(
                () -> Stream.iterate(1, x->x+1)
                        .limit(10)
                        .forEach((x)-> {
                            try {
                                sleep(1000);
                                System.out.println("Hello my friend!");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        })
        );
        Thread thread2 = new Thread(
                () -> Stream.iterate(1, x->x+1)
                        .limit(10)
                        .forEach((x)-> {
                            try {
                                sleep(1500);
                                System.out.println("I love you!");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        })
        );
        thread1.start();
        thread2.start();
        Stream.iterate(1,x->x+1)
                .limit(10)
                .forEach(x -> {
                    try {
                        Thread.sleep(1000);
                        System.out.println("My king!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
        System.out.println("Main thread finished!");
    }
}
