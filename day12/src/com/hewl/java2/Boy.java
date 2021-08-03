package com.hewl.java2;

/**
 *
 * Stream实例化
 *
 * @author wen
 * @date 2021/7/27 - 17:49
 */
public class Boy {
    private Girl girl;

    public Boy() {
    }

    @Override
    public String toString() {
        return "Boy{" +
                "girl=" + girl +
                '}';
    }

    public Boy(Girl girl) {
        this.girl = girl;
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }
}
