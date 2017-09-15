package com.tianyu.example.java8lambda.t2.first;

import java.awt.*;

public class AddActionWithLambda {
    public static void main(String[] args) {
        if (args == null || args.length != 1) return;
        String name = args[0];
        Button button = new Button();
        button.addActionListener(e -> System.out.println("hi " + name));
    }
}
