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
        System.out.println("after use="+exception());
        return myBean.hello();
    }

    public int exception() {
        int a = 1;
        try {
            a++;
//            System.out.println("after try="+a);
//            int b = 1/0;
            return a;
        }catch (Exception e){
//            a++;
//            System.out.println("after catch="+a);
//            return a;
        }finally {


            a++;
//            System.out.println("after finally="+a);
            return a;
        }

    }

}
