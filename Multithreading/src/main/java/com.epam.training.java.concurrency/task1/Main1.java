package com.epam.training.java.concurrency.task1;


import java.util.HashMap;
import java.util.Map;


public class Main1 {

    private static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        //catching ConcurrentModificationException
        //write in map
        Thread thread1 = new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    map.put(i, i);
                    System.out.println("Положили: " + i);
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        //get from map
        Thread thread2 = new Thread() {
            public void run() {
                int sum = 0;
                for (int i = 0; i < 10; i++) {
                    for (Integer integer : map.keySet()) {
                        sum += integer;
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Получили sum: " + sum);
                }
            }
        };
        thread1.start();
        thread2.start();
    }
}
