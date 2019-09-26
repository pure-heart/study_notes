package com.jhly.myBatisDemo;

/**
 * @Auther:JHLY
 * @Date:2019/9/26
 * @Description:com.jhly.myBatisDemo
 * @Version:1.0
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        final ThreadLocal<String> threadLocal = new java.lang.ThreadLocal<>();
        threadLocal.set("测试");
        new Thread() {
            public void run() {
                String result = threadLocal.get();
                System.out.println("结果："+result);
            }
        }.start();
    }
}
