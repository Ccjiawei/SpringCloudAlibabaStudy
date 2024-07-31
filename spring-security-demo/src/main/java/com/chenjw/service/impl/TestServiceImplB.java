package com.chenjw.service.impl;

import com.chenjw.service.TestService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class TestServiceImplB implements TestService {

    @Override
    public void test() {
        System.out.println("TestServiceImplB");
    }
}
