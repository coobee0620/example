package com.tianyu.example.java8lambda.t5;


import com.tianyu.example.java8lambda.data.DataFactory;
import com.tianyu.example.java8lambda.domain.Album;
import com.tianyu.example.java8lambda.domain.Artist;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

/**
 * 收集器工具
 * 转换成值
 */
public class ToValue {
    public static void main(String[] args) {
        Album my = DataFactory.getMy();
        List<Album> albums = DataFactory.getAlbumList();
        Optional<Artist> biggest = biggestGroup(my.musicianStream());
        biggest.ifPresent((artist -> System.out.println(artist.getName())));

        double average = averageNumberOfTracks(albums);
        System.out.println(average);
    }

    /**
     * 找出成员最多的乐队
     */
    public static Optional<Artist> biggestGroup(Stream<Artist> artists) {
        Function<Artist,Long> getCount = artist -> artist.memberStream().count();
        return artists.collect(Collectors.maxBy(comparing(getCount)));
    }

    /**
     * 找出一组专辑上的曲目平均数
     * @param albums
     * @return
     */
    public static double averageNumberOfTracks(List<Album> albums) {
        return albums.stream()
                .collect(Collectors.averagingInt(album -> album.getTracks().size()));
    }
}
