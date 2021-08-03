package com.hewl.java;

/**
 * @author 何文亮
 * @date 2021-06-05
 */
public class User implements Comparable{
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }
    //按照姓名从大到小: return -this.name.compareTo(user.name);

    //按照姓名从小到大,年龄从小到大

    @Override
    public int compareTo(Object o) {
        if(o instanceof User){
            User user = (User)o;
//            return this.name.compareTo(user.name);
            int compare = this.name.compareTo(user.name);
            if(compare != 0){
                return this.name.compareTo(user.name);
            }else{
                return Integer.compare(this.age,user.age);
            }
        }else{
            throw new RuntimeException("输入的数据不匹配");
        }
    }

//    @Override
//    public int hashCode() {
//        int result = name != null ? name.hashCode() : 0;
//        result = 31 * result + age;
//        return result;
//    }
}
