package com.hewl.java;

/**
 * 使用enum关键字来定义枚举类
 *
 * @author 何文亮
 * @date 2021-05-09
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        //toString():
        Season1 autumn = Season1.AUTUMN;
        System.out.println(autumn.toString());
        //values():
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();
        }
        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);
        }
        //valuesOf(String,objname):返回枚举类中对象名是objname的对象。没找到，抛异常
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);
    }
}

interface Info{
    void show();
}
//使用enum关键字定义枚举类
enum Season1 implements Info{
    //1.提供当前枚举类的多个对象之间使用“,”隔开，最后一个使用“;”
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("宁夏");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天不会来");
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };
    //1声明Season对象的属性
    //2私有化类的构造器
    private final String seasonName;
    private final String seasonDesc;
    private Season1(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
    //4其他诉求：获取枚举类对象的属性

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

//    @Override
//    public void show() {
//        System.out.println("这是一个季节！");
//    }
    //提供toString()方法

//    @Override
//    public String toString() {
//        return "Season1{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }

}