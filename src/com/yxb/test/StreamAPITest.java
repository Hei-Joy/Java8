package com.yxb.test;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPITest {

    @Test
    public void test1(){
        List<User> list = UserList.getUserList();
        //filter条件过滤
        list.stream().filter(e -> e.getAge() > 20).forEach(System.out::println);
        System.out.println("-------------------------------");

        //limit取几条数据
        list.stream().limit(1).forEach(System.out::println);
        System.out.println("-------------------------------");

        //skip跳过前几条数据
        list.stream().skip(1).forEach(System.out::println);
        System.out.println("-------------------------------");

        //distinct去重复数据
        list.add(new User("小二",25));
        list.stream().distinct().forEach(System.out::println);
    }

    @Test
    public void test2(){
        //元素转为大写
        List<String> list = Arrays.asList("aa", "bb", "cc");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
        System.out.println(list);
        System.out.println("-------------------------------");

        //获取年龄大于20的姓名
        List<User> userList = UserList.getUserList();
        userList.stream().map(User::getAge).filter(age -> age > 20).forEach(System.out::println);
        System.out.println("-------------------------------");

        //拆分单个字符
        list.stream().flatMap(StreamAPITest::fromStringToStream).forEach(System.out::println);
    }

    //将多个字符构成的集合转换成对应的Stream的实例
    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list = new ArrayList();
        for (Character c : str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void test3(){
        //排序
        List<Integer> asList = Arrays.asList(12, 23, 11, 45, 7);
        asList.stream().sorted().forEach(System.out::println);

        //定制排序
        List<User> list = UserList.getUserList();
        //加上-倒序
        list.stream().sorted( (e1,e2) -> -Integer.compare(e1.getAge(),e2.getAge())).forEach(System.out::println);
    }

    @Test
    public void test4(){
        //匹配查找   allMatch是否所以数都大于10
        List<Integer> asList1 = Arrays.asList(12, 23, 11, 45, 7);
        boolean b = asList1.stream().allMatch(num -> num > 10);
        System.out.println(b);

        //归约 求和
        List<Integer> asList = Arrays.asList(12, 23, 11, 45, 7);
        Integer sum = asList.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        //计算年龄的总和
        List<User> list = UserList.getUserList();
        Optional<Integer> reduce = list.stream().map(User::getAge).reduce(Integer::sum);
        System.out.println(reduce.get());
    }

    @Test
    public void test5(){
        //收集 查找数字大于10，返回一个集合
        List<User> list = UserList.getUserList();
        list.stream().filter(user -> user.getAge() > 10).collect(Collectors.toList()).forEach(System.out::println);
    }
}
