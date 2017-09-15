package com.tianyu.example.java8lambda.t3;


import com.tianyu.example.java8lambda.data.DataFactory;
import com.tianyu.example.java8lambda.domain.Artist;

import java.util.Iterator;

/**
 * 找到来自USA的艺术家数量
 */
public class OuterInner {
    public static void main(String[] args) {
        //需要使用命令编程式思维去理解
        int count =0;
        Iterator<Artist> iterator = DataFactory.getMy().getMusicians().iterator();
        while (iterator.hasNext()) {
            Artist artist = iterator.next();
            if (artist.isFrom("米国")) {
                count ++;
            }
        }
        System.out.println(count);

//        //像是在说一句话，描述一件事情
//        long longCount = DataFactory.getMy().getMusicians().stream() //产生一个流
//                .filter(artist -> artist.isFrom("米国")) //过滤来自米国的艺术家
//                .count(); //数一数
//        System.out.println(longCount);
    }
}
