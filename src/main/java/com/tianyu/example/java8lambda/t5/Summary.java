package com.tianyu.example.java8lambda.t5;

import com.tianyu.example.java8lambda.data.DataFactory;
import com.tianyu.example.java8lambda.domain.Track;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Summary {
    public static void main(String[] args) {
        List<Track> tracks = DataFactory.getMy().getTracks();
        IntSummaryStatistics summary = summary(tracks);
        System.out.println(summary);
    }

    /**
     * 曲目列表时长汇总
     */
    public static IntSummaryStatistics summary(List<Track> trackList) {
        return trackList.stream().collect(Collectors.summarizingInt(track -> track.getLength()));
    }
}
