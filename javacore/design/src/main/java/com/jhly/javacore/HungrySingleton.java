package com.jhly.javacore;

/**
 * 单例模式饿汉式
 * @Auther:JHLY
 * @Date:2019/9/28
 * @Description:com.jhly.javacore
 * @Version:1.0
 */
public class HungrySingleton {
    //类加载时实例化
    private static HungrySingleton singleton =new HungrySingleton();
    private HungrySingleton(){};
    public static HungrySingleton getInstance(){
        return singleton;
    }
}
