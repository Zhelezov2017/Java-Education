package com.epam.zhelezov.runnable.task4;

@FunctionalInterface
interface ThreeFunction<T, U, M, R>{

    /**
     * Applies this function to the given arguments.
     *
     * @param t the first function argument
     * @param u the second function argument
     * @param m the second function argument
     * @return the function result
     */
    R apply(T t, U u, M m);
}
