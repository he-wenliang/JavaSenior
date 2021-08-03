package com.hewl.exer;

import org.junit.Test;

import java.util.*;

/**
 * @author 何文亮
 * @date 2021-06-06
 */
public class CollectionTest {
    @Test
    public void emp1() {
        Comparator com = new Comparator<Employee>() {
            //使用泛型以后
            @Override
            public int compare(Employee o1, Employee o2) {
                MyDate b1 = o1.getBirthday();
                MyDate b2 = o2.getBirthday();
                //这部分可以在MyDate中实现Compareable接口来实现比较
                //方法一：
//                int suby = b1.getYear() - b2.getYear();
//                if (suby != 0) {
//                    return suby;
//                }
//                int subm = b1.getMonth() - b2.getMonth();
//                if (subm != 0) {
//                    return subm;
//                }
//                return b1.getDay() - b2.getDay();
                //方法二:
                return b1.compareTo(b2);
            }
            //使用泛型之前的
//            @Override
//            public int compare(Object o1, Object o2) {
//                if(o1 instanceof Employee && o2 instanceof Employee){
//                    Employee e1 = (Employee)o1;
//                    Employee e2 = (Employee)o2;
//
//                    MyDate b1 = e1.getBirthday();
//                    MyDate b2 = e2.getBirthday();
//                    //这部分可以在MyDate中实现Compareable接口来实现比较
//                    //方法一：
////                    int suby = b1.getYear() - b2.getYear();
////                    if(suby != 0){
////                        return suby;
////                    }
////                    int subm = b1.getMonth() - b2.getMonth();
////                    if(subm != 0){
////                        return subm;
////                    }
////                    return b1.getDay() - b2.getDay();
//                    //方法二:
//                    return b1.compareTo(b2);
//                }
//                throw new RuntimeException("输入数据类型不匹配....");
//            }
        };
        //按照生日
        TreeSet<Employee> set = new TreeSet<>(com);
        set.add(new Employee("liudehua", 55, new MyDate(1967, 9, 14)));
        set.add(new Employee("zhangxueyou", 43, new MyDate(1965, 10, 28)));
        set.add(new Employee("guofucheng", 54, new MyDate(1965, 10, 2)));
        set.add(new Employee("liming", 39, new MyDate(1976, 4, 5)));
        set.add(new Employee("liangchaowei", 50, new MyDate(1978, 9, 3)));

        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void emp() {
        //自然排序
        TreeSet<Employee> set = new TreeSet<Employee>();

        set.add(new Employee("liudehua", 55, new MyDate(1967, 9, 14)));
        set.add(new Employee("zhangxueyou", 43, new MyDate(1965, 10, 28)));
        set.add(new Employee("guofucheng", 54, new MyDate(1965, 10, 2)));
        set.add(new Employee("liming", 39, new MyDate(1976, 4, 5)));
        set.add(new Employee("liangchaowei", 50, new MyDate(1978, 9, 3)));

        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test() {
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(14);
        coll.add(56);

        coll.forEach(System.out::println);
    }
}
