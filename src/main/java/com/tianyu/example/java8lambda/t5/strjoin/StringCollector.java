package com.tianyu.example.java8lambda.t5.strjoin;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class StringCollector implements Collector<String,StringCombiner,String > {
    private static final Set<Characteristics> CH_NOID = Collections.emptySet();
    private String delim;
    private String prefix;
    private String suffix;

    public StringCollector(String delim, String prefix, String suffix) {
        this.prefix = prefix;
        this.delim = delim;
        this.suffix = suffix;
    }

    @Override
    public Supplier<StringCombiner> supplier() {
        return () -> new StringCombiner(delim,prefix,suffix);
    }

    @Override
    public BiConsumer<StringCombiner, String> accumulator() {
        return StringCombiner::add;
    }

    @Override
    public BinaryOperator<StringCombiner> combiner() {
        return StringCombiner::merge;
    }

    @Override
    public Function<StringCombiner, String> finisher() {
        return StringCombiner::toString;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return CH_NOID;
    }
}
