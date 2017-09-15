package com.tianyu.example.java8lambda.t5;


import com.tianyu.example.java8lambda.data.DataFactory;
import com.tianyu.example.java8lambda.domain.Artist;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.partitioningBy;

/**
 * 数据分块
 */
public class PartitioningBy {
    public static void main(String[] args) {
        Map<Boolean,List<Artist>> bandsAndSolo = bandsAndSolo(DataFactory.getMy().musicianStream());

        bandsAndSolo.forEach((aBoolean, artists) -> {
            System.out.println((aBoolean ? "is" : "not" ) + " Solo" );
            System.out.println("Artists:" + artists.stream()
                    .map(Artist::getName)
                    .collect(Collectors.joining(", ","[","]")));
        });
    }

    public static Map<Boolean,List<Artist>> bandsAndSolo(Stream<Artist> artists) {
        return artists.collect(partitioningBy(artist -> artist.isSolo()));
    }
}
