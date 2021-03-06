package com.fly.study.java.generics;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张攀钦
 * @date 2019-09-16-00:04
 * @description 泛型验证
 */
public class ClientTest<T> {

    private ClientTest clientTest;

    private Parent parent;

    private Son son;

    private ClientTest<Son> sonClientTest;

    private ArgsParent argsParent;

    private ArgsSon argsSon;

    /**
     * 测试泛型在类上指定
     */
    public <T extends ArgsParent> void run1(T t) {

        System.out.println(t);
    }

    public void run1(Object t1) {
        System.out.println(t1);
    }
    /**
     * 静态方法的泛型不能使用类上的，只能再方法上声明泛型
     */

    public static <T extends ArgsParent, T2 extends ArgsParent> void run4(T k) {
        System.out.println(k);
    }

    /**
     * 限制方法参数的泛型和返回值类型,泛型优先使用方法上的，当方法上没有使用类上的
     * 不能这样 <K1 super Parent>
     */

    public <T extends ArgsParent, T2 extends ArgsParent> T2 run2(T k) {
        System.out.println(k.getName());
        System.out.println(k);
        return (T2) k;
    }

    /**
     * 方法泛型设定，相当于没有设置
     */
    public <K1> void run3(K1 k) {
        System.out.println(k);
    }

    public void run6(List<? extends ArgsParent> list){
        for (ArgsParent argsParent1 : list) {
            System.out.println(argsParent1.getName());
        }
    }

    @Test
    public void test6(){
        List<ArgsParent> list1=new ArrayList<>();
        list1.add(argsParent);
        List<ArgsSon> list2=new ArrayList<>();
        list2.add(argsSon);
        clientTest.run6(list1);
        clientTest.run6(list2);
    }


    public <T extends ArgsParent> void run5(List<T> list){
        for (ArgsParent argsParent1 : list) {
            System.out.println(argsParent1.getName());
        }
    }

    @Test
    public void test5(){
        List<ArgsParent> list1=new ArrayList<>();
        list1.add(argsParent);
        List<ArgsSon> list2=new ArrayList<>();
        list2.add(argsSon);
        clientTest.run5(list1);
        clientTest.run5(list2);
    }
    @Before
    public void before() {
        clientTest = new ClientTest();
        parent = new Parent();
        parent.setName("parent");

        son = new Son();
        son.setAge(18);

        sonClientTest = new ClientTest<>();

        argsParent = new ArgsParent();
        argsParent.setName("argsParent");
        argsSon = new ArgsSon();
    }


    @Test
    public void test1() {
        // 泛型在类初始化的时候已经定了
        sonClientTest.run1(son);
    }

    @Test
    public void test2() {
        System.out.println(clientTest.run2(argsParent));
        System.out.println(clientTest.run2(argsSon));
        // 验证方法上的泛型优先于类上的泛型
        sonClientTest.run2(argsSon);
//        下面用法错误
//        sonClientTest.run2(son);
    }


    @Test
    public void test3() {
        clientTest.run3(parent);
        clientTest.run3(son);
        clientTest.run3("son");
    }
}
