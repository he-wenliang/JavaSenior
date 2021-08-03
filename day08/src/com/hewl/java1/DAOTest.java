package com.hewl.java1;

import org.junit.Test;

import java.util.List;

/**
 * @author wen
 * @date 2021-06-08
 */
public class DAOTest {
    @Test
    public void test(){
        CustomerDAO dao = new CustomerDAO();
        dao.add(new Customer());
        List<Customer> list = dao.getForList(10);

        StudentDAO dao1 = new StudentDAO();
        Student student = dao1.getIndex(1);

    }
}
