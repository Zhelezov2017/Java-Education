package com.epam.zhelezov.runnable.task4;

public class MainTask4 {
    public static void main(String[] args) {
        //2 Implementation
        ThreeFunction<Integer, Integer, Integer, String> threeFunctionImpl1 = (Integer strength, Integer agility, Integer mind) -> {
            int power = strength + agility + mind;
            return "Total power of the hero" + " " + power;
        };
        ThreeFunction<String, Integer, Integer, String> threeFunctionImpl2 = (String name, Integer age, Integer level)
                -> "Name hero: " + name + "; "
                + "Age: " + age + "; " +
                "Level: " + level;
        System.out.println("What is hero name and age?");
        System.out.println(threeFunctionImpl2.apply("Axil", 32, 7));
        System.out.println("Calculate the strength of the hero!");
        System.out.println(threeFunctionImpl1.apply(17, 19, 31));
    }
}


