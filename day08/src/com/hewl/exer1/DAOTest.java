package com.hewl.exer1;

import java.util.List;

/**
 * @author wen
 * @date 2021-06-09
 */
public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();

        dao.save("1001",new User(1001,25,"Guo"));
        dao.save("1002",new User(1002,30,"Andy"));
        dao.save("1003",new User(1003,19,"Hans"));

        dao.update("1001",new User(1003,30,"Judy"));
        dao.delete("1003");

        List<User> list = dao.List();
//        System.out.println(list);
        list.forEach(System.out::println);
    }
}
