package com.tianyu.example.java8lambda.t5;


import com.tianyu.example.java8lambda.data.DataFactory;
import com.tianyu.example.java8lambda.domain.Album;
import com.tianyu.example.java8lambda.domain.Artist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 收集器组合使用
 */
public class CombinedCollector {
    public static void main(String[] args) {
        /*
         * 计算每个艺术家的专辑数
         * Collectors.counting
         */
        //Before
        Stream<Album> albums = DataFactory.getAlbums();
        Map<Artist,List<Album>> albumsByArtist = albums.collect(Collectors.groupingBy(Album::getMusician));

        Map<Artist,Integer> intNumberOfAlbums = new HashMap<>();
        for (Map.Entry<Artist,List<Album>> entry : albumsByArtist.entrySet()) {
            intNumberOfAlbums.put(entry.getKey(),entry.getValue().size());
        }

        String result = intNumberOfAlbums.entrySet().stream()
                .map(entry -> entry.getKey().getName() + ":" +entry.getValue())
                .collect(Collectors.joining(", ","[","]"));
        System.out.println(result);

        //Java8
        albums = DataFactory.getAlbums();
        Map<Artist,Long> longNumberOfAlbums = albums.collect(Collectors.groupingBy(Album::getMusician,Collectors.counting()));
        result = longNumberOfAlbums.entrySet().stream()
                .map(entry -> entry.getKey().getName() + ":" +entry.getValue())
                .collect(Collectors.joining(", ","[","]"));
        System.out.println(result);

        /*
        * 计算每个艺术家的专辑名
        * Collectors.mapping
        * */
        //before
        albums = DataFactory.getAlbums();
        albumsByArtist = albums.collect(Collectors.groupingBy(Album::getMusician));

        Map<Artist,List<String>> nameOfAlbums = new HashMap<>();
        for (Map.Entry<Artist,List<Album>> entry : albumsByArtist.entrySet()) {
            nameOfAlbums.put(entry.getKey(),entry.getValue()
                    .stream()
                    .map(Album::getName)
                    .collect(Collectors.toList()));
        }

        result = nameOfAlbums.entrySet().stream()
                .map(entry -> entry.getKey().getName() + ":" +entry.getValue())
                .collect(Collectors.joining(", ","[","]"));
        System.out.println(result);

        //Java8
        albums = DataFactory.getAlbums();
        nameOfAlbums = albums.collect(Collectors.groupingBy(Album::getMusician
                                                            ,Collectors.mapping(Album::getName,Collectors.toList())));
        result = nameOfAlbums.entrySet().stream()
                .map(entry -> entry.getKey().getName() + ":" +entry.getValue())
                .collect(Collectors.joining(", ","[","]"));
        System.out.println(result);
    }
}
