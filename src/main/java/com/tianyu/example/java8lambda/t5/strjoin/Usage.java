package com.tianyu.example.java8lambda.t5.strjoin;


import com.tianyu.example.java8lambda.data.DataFactory;
import com.tianyu.example.java8lambda.domain.Artist;

import java.util.List;

/**
 * 自定义收集器
 */
public class Usage {
    public static void main(String[] args) {
        List<Artist> artistList = DataFactory.getMy().getMusicians();
        System.out.println(java7(artistList));
        System.out.println(step1(artistList));
        System.out.println(step2(artistList));
        System.out.println(step3(artistList));
        System.out.println(step4(artistList));
    }

    public static String java7(List<Artist> artistList) {
        if (artistList == null || artistList.size()==0) {
            return "";
        }
        StringBuilder builder = new StringBuilder("[");
        for (Artist artist : artistList) {
            if (builder.length() > 1) {
                builder.append(", ");
            }
            String name = artist.getName();
            builder.append(name);
        }
        builder.append("]");
        return builder.toString();
    }

    public static String step1(List<Artist> artistList) {
        if (artistList == null || artistList.size()==0) {
            return "";
        }
        StringBuilder builder = new StringBuilder("[");
        artistList.stream()
                .map(Artist::getName)
                .forEach(name -> {
                    if (builder.length() > 1) builder.append(", ");
                    builder.append(name);
                });
        builder.append("]");
        return builder.toString();
    }

    public static String step2(List<Artist> artistList) {
        if (artistList == null || artistList.size()==0) {
            return "";
        }
        StringBuilder reduced =
        artistList.stream()
                .map(Artist::getName)
                .reduce(new StringBuilder(),
                    (builder,name) -> {
                        if (builder.length() > 0)
                            builder.append(", ");
                        builder.append(name);
                        return builder;
                    },
//                    (left,right) -> left.append(right));
                    StringBuilder::append);
        reduced.insert(0,"[");
        reduced.append("]");
        return reduced.toString();
    }

    public static String step3(List<Artist> artistList) {
        if (artistList == null || artistList.size()==0) {
            return "";
        }
        return artistList.stream()
                .map(Artist::getName)
//                .reduce(new StringCombiner(", ","[","]"),
//                        (combiner,element) -> combiner.add(element),
//                        (left,right) -> left.merge(right))
                .reduce(new StringCombiner(", ","[","]"),
                        StringCombiner::add,
                        StringCombiner::merge)
                .toString();
    }

    public static String step4(List<Artist> artistList) {
        if (artistList == null || artistList.size()==0) {
            return "";
        }
        return artistList.stream()
                .map(Artist::getName)
                .collect(new StringCollector(", ","[","]"));
    }
}
