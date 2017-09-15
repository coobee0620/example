package com.tianyu.example.java8lambda.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 曲目
 */
@Getter
@Setter
public class Track {
    private String name;
    private int length;

    public Track(String name) {
        this.name = name;
    }

    public Track(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public Track() {
    }
}
