package com.yxb.test;

import java.util.ArrayList;
import java.util.List;

public class UserList {

    public static List<User> getUserList(){
        List<User> list = new ArrayList<>();
        list.add(new User("张三",18));
        list.add(new User("王五",21));
        list.add(new User("赵六",30));
        return list;
    }
}
