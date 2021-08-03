package com.hewl.java1;

import java.util.List;

/**
 * @author wen
 * @date 2021-06-08
 *
 * DAO:data access object(数据访问对象)
 */
public class DAO<T> {//表的共性操作DAO
    //添加
    public void add(T t){

    }
    //删除
    public boolean remove(int index){
        return false;
    }
    //修改
    public void update(int index,T t){

    }
    //查询一条
    public T getIndex(int index){
        return null;
    }
    //查询多条
    public List<T> getForList(int index){
        return null;
    }
    //泛型方法
    //获取表中一共有多少条数据？获取最大员工入职时间？
    public <E> E getValue(){
        return null;
    }
}
