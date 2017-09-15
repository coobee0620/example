package com.tianyu.example.java8lambda.t2.sideeffect;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SideEffectFunction {
    public static void main(String[] args) {
        List<Integer> list = Stream.of(1,2,3).collect(Collectors.toList());

        Supplier<List<Integer>> sideEffect = () -> {
            list.add(5);
            return list;
        };

        sideEffect(sideEffect);

        Function<List<Integer>,List<Integer>> nonSideEffect = (l) -> {
            List<Integer> theNew = new ArrayList<>(l);
            theNew.add(5);
            return theNew;
        };

        nonSideEffect(nonSideEffect,list);

    }

    public static void sideEffect(Supplier<List<Integer>> s) {
        if (s != null) {
            List theList = s.get();
        }
    }

    public static void nonSideEffect(Function<List<Integer>,List<Integer>> f,List<Integer> originList) {
        if (f != null) {
            List<Integer> theList = f.apply(originList);
        }
    }
}
