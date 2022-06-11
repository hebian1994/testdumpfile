package com.mark.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "oom")
//@PropertySource("classpath:selfdefine.properties")
public class OomConfig {
    private String threadNum;

    public String getThreadNum() {
        return threadNum;
    }

    public void setThreadNum(String threadNum) {
        this.threadNum = threadNum;
    }

    public OomConfig() {
    }

    public OomConfig(String threadNum) {
        this.threadNum = threadNum;
    }
}
