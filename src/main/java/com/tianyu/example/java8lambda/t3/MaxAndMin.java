package com.tianyu.example.java8lambda.t3;


import com.tianyu.example.java8lambda.data.DataFactory;
import com.tianyu.example.java8lambda.domain.Track;

import java.util.Comparator;
import java.util.List;

/**
 * 最大值最小值
 */
public class MaxAndMin {
    public static void main(String[] args) {
        List<Track> tracks = DataFactory.getMy().getTracks();
        Track minTrack = tracks.stream()
                .min(Comparator.comparing(Track::getLength)).get();
        System.out.println(minTrack.getLength());

        Track maxTrack = tracks.stream()
                .max(Comparator.comparing(Track::getLength)).get();
        System.out.println(maxTrack.getLength());
    }
}
