package com.mark.oom1normal;

import com.mark.config.OomConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * unable to create new native thread：无法创建新的线程。
 * 原因：
 * 1.应用程序创建了太多的线程，超过了系统承载。
 * 2.服务器不允许你的应用创建这么多线程。linux用户除了Root以外默认创建线程数是1024.
 * 解决办法：
 * 1.修改用户创建线程数量。查看当前用户的线程数量。ulimit -u  修改：vim /etc/security/limits.d/90-nproc.conf
 * 2.修改程序。降低应用程序的线程数量。
 * <p>
 * https://blog.csdn.net/liuerchong/article/details/116453690
 */

@Component
public class OOM_UTCNNT {

    public static void main(String[] args) {
        OOM_UTCNNT oom_utcnnt = new OOM_UTCNNT();

        oom_utcnnt.test2();
    }

    @Autowired
    private OomConfig oomConfig;

    public void test2() {
        // 创建Runnable接口的实现类对象
        RunnableDemo_03 runnableDemo_03 = new RunnableDemo_03();
        // 创建线程对象，通过线程对象来开启我们的线程，代理
        String threadNum = oomConfig.getThreadNum();
        int threadNumInt = Integer.parseInt(threadNum);
        System.out.println(threadNumInt);
//        for (int i = 0; i < 14572; i++) {
        for (int i = 0; i < threadNumInt; i++) {
            System.out.println("新建线程" + i);
            System.out.println("前当前线程数" + Thread.activeCount());
            //最终的线程数应该是GC线程+Main线程+15572个demo线程
            Thread thread = new Thread(runnableDemo_03);// 调用start()启动线程
            thread.start();
            System.out.println("后当前线程数" + Thread.activeCount());
        }
    }
}
