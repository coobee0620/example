package com.tianyu.example.java8lambda.t6;


import com.tianyu.example.java8lambda.data.DataFactory;
import com.tianyu.example.java8lambda.domain.Track;

import java.util.List;

/**
 * ParallelRestriction
 *
 * @Author yu.tian@mtime.com
 * @Date 17/9/7 11:49
 */
public class ParallelRestriction {
    public static void main(String[] args) {
        List<Track> trackList = DataFactory.getMy().getTracks();

        int sum = trackList.stream()
                .mapToInt(Track::getLength)
                .reduce(0,(acc, element) -> acc + element);

        System.out.println(sum);
    }
}
