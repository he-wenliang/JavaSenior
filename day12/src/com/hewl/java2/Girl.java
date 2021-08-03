package com.hewl.java2;

/**
 * @author wen
 * @date 2021/7/28 - 16:45
 */
public class Girl {
    private String name;

    public Girl() {
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }

    public Girl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
