package com.mark.oom1normal;

/**
 * 堆溢出
 * <p>
 * 设置堆初始值，最大值
 * -Xms30m -Xmx30m -XX:+PrintGCDetails
 * 报异常打印堆栈信息
 * -XX:+HeapDumpOnOutOfMemoryError
 * <p>
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 * 堆满了，触发垃圾回收，但是回收不了，因为strings时要留着使用的
 */
public class OOM_heap {
    public static void main(String[] args) {
        String[] strings = new String[35 * 1000 * 1000];//35M的数组存入堆空间
    }
}
