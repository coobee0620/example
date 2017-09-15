package com.tianyu.example.java8lambda.t2.first;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAction {
    public static void main(String[] args) {
        Button button = new Button();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button clicked");
            }
        });
    }
}
