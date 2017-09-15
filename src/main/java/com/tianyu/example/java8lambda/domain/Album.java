package com.tianyu.example.java8lambda.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Stream;

/**
 * 专辑
 */
@Getter
@Setter
public class Album {
    private String name;
    private List<Track> tracks;
    private List<Artist> musicians;
    private Artist musician;

    public Album(String name, List<Track> tracks, List<Artist> musicians) {
        this.name = name;
        this.tracks = tracks;
        this.musicians = musicians;
    }

    public Album(String name, List<Track> tracks,Artist musician) {
        this.name = name;
        this.tracks = tracks;
        this.musician = musician;
    }

    public Album() {
    }

    public Stream<Artist> musicianStream() {
        if (this.musicians != null) {
            return this.musicians.stream();
        }
        return Stream.of();
    }

    public Stream<Track> trackStream() {
        if (this.tracks != null) {
            return this.tracks.stream();
        }
        return Stream.of();
    }

}
