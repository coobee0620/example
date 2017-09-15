package com.tianyu.example.java8lambda.t5.strjoin;

import lombok.Getter;

public class StringCombiner {
    @Getter
    private String prefix;
    @Getter
    private String delim;
    @Getter
    private String suffix;
    @Getter
    private StringBuilder builder;

    private volatile boolean finished = false;

    public StringCombiner(String delim, String prefix, String suffix) {
        this.prefix = prefix;
        this.delim = delim;
        this.suffix = suffix;
        this.builder = new StringBuilder(this.prefix);
    }

    public StringCombiner add(String element) {
        if (!areAtStart()) builder.append(delim);
        builder.append(element);
        return this;
    }

    public StringCombiner merge(StringCombiner other) {
        this.builder.append(other.getBuilder());
        return this;
    }

    private boolean areAtStart() {
        return (builder == null ? 0 : builder.length()) == (prefix == null ? 0 :prefix.length());
    }

    @Override
    public synchronized String toString() {
        if (builder == null) {
            builder = new StringBuilder();
        }
        if (!finished) {
            builder.append(suffix);
            finished = true;
        }
        return builder.toString();
    }
}
