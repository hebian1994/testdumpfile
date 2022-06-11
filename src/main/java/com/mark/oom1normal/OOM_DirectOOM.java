package com.mark.oom1normal;

import java.nio.ByteBuffer;

/**
 * OOM
 * 直接内存溢出
 * -XX:MaxDirectMemorySize=100m
 * 限制最大直接内存大小100m
 * <p>
 * NIO相关的会使用到直接内存
 * <p>
 * Exception in thread "main" java.lang.OutOfMemoryError: Direct buffer memory
 */
public class OOM_DirectOOM {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(128 * 1000 * 1000);
    }
}
