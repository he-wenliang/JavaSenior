package com.hewl.exer;

/**
 * @author 何文亮
 * @date 2021-06-06
 */
public class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(MyDate o) {
        int suby = this.getYear() - o.getYear();
        if (suby != 0) {
            return suby;
        }
        int subm = this.getMonth() - o.getMonth();
        if (subm != 0) {
            return subm;
        }
        return this.getDay() - o.getDay();
    }

//    @Override
//    public int compareTo(Object o) {
//        if(o instanceof MyDate){
//            MyDate m = (MyDate)o;
//
//            int suby = this.getYear() - m.getYear();
//            if(suby != 0){
//                return suby;
//            }
//            int subm = this.getMonth() - m.getMonth();
//            if(subm != 0){
//                return subm;
//            }
//            return this.getDay() - m.getDay();
//        }
//        throw new RuntimeException("输入数据类型不匹配....");
//    }
}
