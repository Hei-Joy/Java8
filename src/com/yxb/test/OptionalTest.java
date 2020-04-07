package com.yxb.test;

import org.junit.Test;

import java.util.Optional;

public class OptionalTest {

    @Test
    public void test1(){
        User user = new User();
        //of(T t):t保证是非空的
        //user = null;
        Optional<User> optionalUser = Optional.of(user);
        System.out.println(optionalUser);
    }

    @Test
    public void test2(){
        User user = new User();
        //ofNullable(T t):t可以为空
        user = null;
        Optional<User> optionalUser = Optional.ofNullable(user);
        System.out.println(optionalUser);
        //orElse:如果当前的optional内部封装的t是非空的,则返回内部的t
        //如果内部封装的t是空的,则返回orElse参数中的t1
        User user1 = optionalUser.orElse(new User("bobo", 44));
        System.out.println(user1);
    }
}
