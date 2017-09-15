package com.tianyu.example.java8lambda.t3;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * reduce求和
 */
public class Reduce {
    public static void main(String[] args) {
        /*
        * lambda求和
        * */
        int count = Stream.of(1,2,3)
                .reduce(0,(acc,element) -> acc + element);
        System.out.println(count);

        /*
        * 低纬度展开
        * */
        BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;
        count = accumulator.apply(accumulator.apply(
                accumulator.apply(0,1),
                2),
                3);
        System.out.println(count);

        /*
         * 命令式
         */
        count = 0;
        for(Integer element : Arrays.asList(1,2,3)) {
            count = count + element;
        }
        System.out.println(count);
    }
}
