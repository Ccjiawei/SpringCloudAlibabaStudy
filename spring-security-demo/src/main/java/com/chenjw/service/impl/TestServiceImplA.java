package com.chenjw.service.impl;

import com.chenjw.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImplA implements TestService {

    @Override
    public void test() {
        System.out.println("TestServiceImplB");
    }
}
