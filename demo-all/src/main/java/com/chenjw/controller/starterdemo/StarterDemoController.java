package com.chenjw.controller.starterdemo;

import com.chenjw.bean.MyBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StarterDemoController {

    @Resource
    MyBean myBean;

    @GetMapping("/starterdemo")
    public String starterDemo() {
        return myBean.hello();
    }
}
