package com.chenjw.controller;

import com.chenjw.anno.Log;
import com.chenjw.service.TestService;
import com.chenjw.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class HelloController {

    @Resource
    private UserService userService;

    @Resource
    @Qualifier("testServiceImplB")
    private TestService testService;

    @Log("warn")
    @GetMapping("hello")
    public ModelAndView hello(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
//        final int i = 1 / 0;

//        testService.test();

        return mav;
    }


    @Log("error")
    @GetMapping("admin/hello")
    @ResponseBody
    public String adminHello(){
        return "adminHello";
    }

//    @Log("error")
//    @GetMapping("gid")
//    @ResponseBody
//    public User getUserById(@RequestParam int id){
//        return userService.getUserById(id);
//    }

}
