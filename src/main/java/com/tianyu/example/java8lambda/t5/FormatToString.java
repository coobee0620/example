package com.tianyu.example.java8lambda.t5;


import com.tianyu.example.java8lambda.data.DataFactory;
import com.tianyu.example.java8lambda.domain.Album;
import com.tianyu.example.java8lambda.domain.Artist;

import java.util.stream.Collectors;

/**
 * 输出格式化的艺术家列表
 */
public class FormatToString {
    public static void main(String[] args) {
        Album album = DataFactory.getMy();

        //Before
        StringBuilder builder = new StringBuilder("[");
        for (Artist artist : album.getMusicians()) {
            if (builder.length() > 1) {
                builder.append(", ");
            }
            String name = artist.getName();
            builder.append(name);
        }
        builder.append("]");
        String result = builder.toString();
        System.out.println(result);

        //Java8
        result = album.getMusicians().stream()
                .map(Artist::getName) //流转化成音乐家名字的流
                .collect(Collectors.joining(", ","[","]"));//收集、连接
        System.out.println(result);
    }
}
