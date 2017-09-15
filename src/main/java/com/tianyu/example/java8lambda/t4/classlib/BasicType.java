package com.tianyu.example.java8lambda.t4.classlib;


import com.tianyu.example.java8lambda.data.DataFactory;
import com.tianyu.example.java8lambda.domain.Album;

import java.util.IntSummaryStatistics;

public class BasicType {
    public static void main(String[] args) {
        printTrackLengthStatistics(DataFactory.getMy());
    }

    public static void printTrackLengthStatistics(Album album) {
        IntSummaryStatistics summary = album.trackStream()
                .mapToInt(track -> track.getLength())
                .summaryStatistics();
        System.out.println("Max :" + summary.getMax());
        System.out.println("Min : " + summary.getMin());
        System.out.println("Average: " + summary.getAverage());
        System.out.println("Sum: " + summary.getSum());
    }
}
