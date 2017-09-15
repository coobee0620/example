package com.tianyu.example.java8lambda.t3;


import com.tianyu.example.java8lambda.data.DataFactory;
import com.tianyu.example.java8lambda.domain.Album;
import com.tianyu.example.java8lambda.domain.Track;
import com.tianyu.example.java8lambda.t4.Fi;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 多余的流操作
 * 典型错误
 * 假定有一组专辑，找出其中所有长度大于1分钟的曲目的名称。
 */
public class UncalledForStream {
    public static void main(String[] args) {
        List<Album> albums = DataFactory.getAlbumList();
        List<Track> tracks = albums.stream().flatMap(albume -> albume.getTracks().stream()).collect(Collectors.toList());

        List<Track> longTracks = tracks.stream().filter(track -> track.getLength() > 60).collect(Collectors.toList());

        Set<String> longTrackNames = longTracks.stream().map(artist -> artist.getName()).collect(Collectors.toSet());
        Fi.test();
    }
}
