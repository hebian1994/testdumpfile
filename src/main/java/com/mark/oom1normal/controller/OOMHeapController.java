package com.mark.oom1normal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述：
 *
 * @Author：makang
 * @Date: 2021/5/9 16:55
 */
@Controller
public class OOMHeapController {

    /**
     * https://zhuanlan.zhihu.com/p/372721732
     * nohup java -jar -Xms32M -Xmx32M -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/usr/local user-0.0.1-SNAPSHOT.jar  > log.file  2>&1 &
     * @return
     */
    @GetMapping("/oom")
    public String indexJumpPage(){
        Map<String,Object> map = new HashMap<>();

        for (int i = 0; i < 1000000000; i++) {
            map.put("key"+i,i);
        }
        return "index";
    }
}
