package com.yxb.test;

import org.junit.Test;

import java.util.function.Supplier;

public class LambdaTest {

    @Test
    public void test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱天安门！！！！");
            }
        };
        r1.run();

        System.out.println("**************************");

        Runnable r2 = () -> System.out.println("我爱故宫！！！！");
        r2.run();
    }

    //方法引用
    @Test
    public void test2(){
        User user = new User("zhangsan",18);
        Supplier<String> supplier = user :: getName;
        System.out.println(supplier.get());
    }


}
