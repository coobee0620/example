package com.tianyu.example.java8lambda.t5;


import com.tianyu.example.java8lambda.data.DataFactory;
import com.tianyu.example.java8lambda.domain.Album;
import com.tianyu.example.java8lambda.domain.Artist;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

/**
 * 将专辑按照主唱分组
 */
public class GroupingBy {
    public static void main(String[] args) {
        Map<Artist, List<Album>> grouped = albumsByArtist(DataFactory.getAlbums());

        grouped.forEach(((artist, albums) -> {
            System.out.println(artist.getName() + ":" + albums.stream().map(Album::getName).collect(Collectors.joining(", ","[","]")));
        }));
    }
    public static Map<Artist, List<Album>> albumsByArtist(Stream<Album> albums) {
        /*
        * 1.收集专辑流
        * 2.按照艺术家分组专辑
        * */
        return albums.collect(groupingBy(Album::getMusician));
    }
}
