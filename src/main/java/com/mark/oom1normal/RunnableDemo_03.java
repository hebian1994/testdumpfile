package com.mark.oom1normal;

public class RunnableDemo_03 implements Runnable {

    /**
     * 1、实现Runnable接口
     * 2、重写run方法，执行线程需要丢入Runnable接口实现类
     * 3、调用start()启动线程
     */

    @Override
    public void run() { // run方法线程体
        try {
            Thread.sleep(1000000000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        for (int i = 1; i < 11; i++) {
//            System.out.println("我正在抽烟，让我数数吐了几个烟圈"+i);
//        }
    }
}

