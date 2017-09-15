package com.tianyu.example.java8lambda.t3;


import com.tianyu.example.java8lambda.data.DataFactory;
import com.tianyu.example.java8lambda.domain.Album;
import com.tianyu.example.java8lambda.domain.Track;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 假定有一组专辑，找出其中所有长度大于1分钟的曲目的名称。
 */
public class Refactor {
    public static void main(String[] args) {
        Set<String> result = findLongTracks(DataFactory.getAlbumList());
        print(result);

        result = step1(DataFactory.getAlbumList());
        print(result);

        result = step2(DataFactory.getAlbumList());
        print(result);

        result = step3(DataFactory.getAlbumList());
        print(result);

        result = step4(DataFactory.getAlbumList());
        print(result);
    }

    public static void print(Set<String> result) {
        if (result != null) {
            String strResult = result.stream().collect(Collectors.joining(", ","[","]"));
            System.out.println(strResult);
        }
    }

    /**
     * 传统代码
     * @param albums
     * @return
     */
    static Set<String> findLongTracks(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        for (Album album:albums) {
            for (Track track : album.getTracks() ) {
                if (track.getLength() > 60) {
                    String name = track.getName();
                    trackNames.add(name);
                }
            }
        }
        return trackNames;
    }

    /**
     * 重构第一步
     * 替换for外部迭代
     * 感觉更不知道在说什么了
     * @param albums
     * @return
     */
    public static Set<String> step1(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        albums.stream()
                .forEach( album -> {
                    album.getTracks()
                            .forEach(track -> {
                                if (track.getLength() > 60) {
                                    String name = track.getName();
                                    trackNames.add(name);
                                }
                            });
                });
        return trackNames;
    }

    /**
     * 重构第二步
     * 内层迭代lambda化
     * 看着有点样子了
     * @param albums
     * @return
     */
    public static Set<String> step2(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        albums.stream()
                .forEach( album -> {
                    album.getTracks().stream()
                            .filter(track -> track.getLength() > 60)
                            .map(track -> track.getName())
                            .forEach(name -> trackNames.add(name));
                });
        return trackNames;
    }

    /**
     * 重构第三步
     * 外层迭代lambda化
     * 耳目一新，这还不是终点
     * @param albums
     * @return
     */
    public static Set<String> step3(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        albums.stream()
                .flatMap(album -> album.getTracks().stream())
                .filter(track -> track.getLength() > 60)
                .map(track -> track.getName())
                .forEach(name -> trackNames.add(name));
        return trackNames;
    }

    /**
     * 重构第四步
     * 完全lambda，收集器代替迭代
     * @param albums
     * @return
     */
    public static Set<String> step4(List<Album> albums) {
        return albums.stream() //获取流
                .flatMap(album -> album.getTracks().stream()) //将专辑流整合成曲目流
                .filter(track -> track.getLength() > 60) //过滤
                .map(Track::getName) //将曲目流加工成曲目名称流
                .collect(Collectors.toSet()); //收集器来
    }
}
