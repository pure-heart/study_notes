package com.jhly.javacore;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class SingletonTest {

    @Test
    public void test01() {
        LazySingleton singleton1 = LazySingleton.getInstance();
        LazySingleton singleton2 = LazySingleton.getInstance();
        System.out.println(singleton1 == singleton2);
    }
    @Test
    public void test02(){
        HungrySingleton singleton1 = HungrySingleton.getInstance();
        HungrySingleton singleton2 = HungrySingleton.getInstance();
        System.out.println(singleton1 == singleton2);
    }
}
