package com.hewl.java1;

import java.io.Serializable;

/**
 * @author wen
 * @date 2021-07-18
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }
}
