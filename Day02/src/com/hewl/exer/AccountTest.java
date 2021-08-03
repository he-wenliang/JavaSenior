package com.hewl.exer;

/**
 * 两个用户分别向一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。
 * <p>
 * 分析：多线程问题，两个用户线程
 * 共享数据：账户（账户余额）
 * 有线程安全问题：同步机制，三种方法
 *
 * @author 何文亮
 * @date 2021-03-20
 */

class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    //存钱
    public synchronized void deposit(double amt) {
        if (amt > 0) {
            balance += amt;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+":存钱成功，余额为：" + balance);
        }
    }
}

class Customer extends Thread {
    private Account acct;

    public Customer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acct.deposit(1000);
        }

    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account acct = new Account(0);

        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();
    }
}
