package com.mark.oom1normal;

/**
 * OOM
 * 栈溢出
 * <p>
 * -Xss1m
 * 栈的大小默认是1M
 * <p>
 * java.lang.StackOverflowError
 */
public class OOM_stackOverFlow {
    static int count;

    public void king() {
        count++;
        king();
    }

    public static void main(String[] args) throws Throwable {
        OOM_stackOverFlow oom_stackOverFlow = new OOM_stackOverFlow();
        try {
            oom_stackOverFlow.king();
        } catch (Throwable throwable) {
            System.out.println("调用count=>>>" + count);
            throwable.printStackTrace();
        }

    }
}
