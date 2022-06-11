package com.mark.oom1normal.controller;

import com.mark.oom1normal.OOM_UTCNNT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class OOMUTCNNTController {
    @Autowired
    OOM_UTCNNT oom_utcnnt;

    @GetMapping("/oom2")
    public String indexJumpPage() {
        oom_utcnnt.test2();
        return "index";
    }
}
