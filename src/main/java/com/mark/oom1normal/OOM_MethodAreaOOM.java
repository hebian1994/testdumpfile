package com.mark.oom1normal;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * 方法区OOM
 * -XX:MaxMetaspaceSize=10m -XX:+PrintGC
 * <p>
 * Caused by: java.lang.OutOfMemoryError: Metaspace
 */
public class OOM_MethodAreaOOM {
    public static void main(String[] args) {
        while (true) {//不停循环加载。都会存入方法区
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(TestObect.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(
                    (MethodInterceptor) (arg0, arg1, arg2, arg3) -> arg3.invokeSuper(arg0, arg2)
            );
            enhancer.create();//加载一次，加载了一个静态类。
        }
    }

    public static class TestObect { //静态变量放到方法区
        private double a = 33.33;
        private Integer b = 888;
    }

}
