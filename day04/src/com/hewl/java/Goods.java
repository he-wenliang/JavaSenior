package com.hewl.java;

/**
 * 商品类
 *
 * @author 何文亮
 * @date 2021-05-09
 */
public class Goods implements Comparable{
    private String name;
    private double price;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
//指定商品比较大笑的方法:价格从低到高,再按照产品名称从低到高
    @Override
    public int compareTo(Object o) {
        if(o instanceof Goods){
            Goods goods = (Goods)o;
            if(this.price > goods.price){
                return 1;
            }else if (this.price < goods.price){
                return -1;
            }else{
                //return 0;
                return this.name.compareTo(goods.name);
            }
            //方法二：
            //return Double.compare(this.price, goods.price);
        }
        throw new RuntimeException("传入的数据类型不一致！");
    }
}
