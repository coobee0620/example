package com.tianyu.example.java8lambda.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Stream;

/**
 * 艺术家
 */
@Getter
@Setter
public class Artist {
    private String name;
    private List<String> members;
    private String origin;

    public Artist(String name, List<String> members, String origin) {
        this.name = name;
        this.members = members;
        this.origin = origin;
    }

    public Artist(String name,String origin) {
        this.name = name;
        this.origin = origin;
    }

    public Artist() {
    }

    public boolean isFrom(String from) {
        if (origin == null || origin.length() == 0) return false;
        return origin.equals(from);
    }

    public Stream<String> memberStream() {
        if (this.members != null) return members.stream();
        return Stream.of();
    }

    public boolean isSolo() {
        return members == null || members.size() == 0;
    }
}
