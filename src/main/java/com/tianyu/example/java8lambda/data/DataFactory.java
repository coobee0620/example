package com.tianyu.example.java8lambda.data;


import com.tianyu.example.java8lambda.domain.Album;
import com.tianyu.example.java8lambda.domain.Artist;
import com.tianyu.example.java8lambda.domain.Track;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataFactory {
    private static Album my;
    private static List<Album> albums;

    static {
        Artist KatyPerry = new Artist("水果姐","米国");
        Artist BrunoMars = new Artist("火星哥","米国");
        Artist Mayday = new Artist("五月天", Arrays.asList("阿信","怪兽","石头","玛莎"),"中国台湾省");
        Artist LisaOno = new Artist("小野丽莎","霓虹国");
        List<Artist> artistList = Stream.of(KatyPerry,BrunoMars,Mayday,LisaOno).collect(Collectors.toList());
        Track t1 = new Track("Chained to the Rhythm",312);
        Track t2 = new Track("24K Magic",242);
        Track t3 = new Track("倔强",225);
        Track t4 = new Track("Fly Me To The Moon",332);
        Track t5 = new Track("Yo u’re So Unique",59);
        List<Track> trackList = Stream.of(t1,t2,t3,t4).collect(Collectors.toList());
        List<Track> fs = Stream.of(t1).collect(Collectors.toList());
        List<Track> ms = Stream.of(t2).collect(Collectors.toList());
        List<Track> ws = Stream.of(t3).collect(Collectors.toList());
        List<Track> xs = Stream.of(t4,t5).collect(Collectors.toList());

        my = new Album("my",trackList,artistList);

        albums = Stream.of(new Album("fs",fs,KatyPerry)
                ,new Album("ms",ms,BrunoMars)
                ,new Album("ws",ws,Mayday)
                ,new Album("xs",xs,LisaOno)
                ).collect(Collectors.toList());
    }

    public static Album getMy() {
        return my;
    }

    public static Stream<Album> getAlbums() {return albums.stream();}

    public static List<Album> getAlbumList() {return albums;}
}
