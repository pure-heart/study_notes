package com.jhly.javacore;

/**
 * 单例设计模式懒汉式
 * @Auther:JHLY
 * @Date:2019/9/28
 * @Description:com.jhly.javacore
 * @Version:1.0
 */
public class LazySingleton {
    /*
       静态方法调用的对象也必须是静态的
       静态方法必须设置访问修饰符为private，防止其他类调用
     */
    private static LazySingleton lazySingleton;

    //构造函数私有化
    private LazySingleton() {
    }

    /**
     * 提供对外的访问接口
     * 无法直接创建对象所以设置方法为静态方法，否则无法调用
     * 多线程下可能出现同时调用的情况导致无法创建对象 所以需要添加锁
     *
     * @return
     */
    public static LazySingleton getInstance() {
        //如果实例化过，直接返回
        if (lazySingleton == null) {
            synchronized (LazySingleton.class) {
                //双重验证
                if (lazySingleton == null) {
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }
}
