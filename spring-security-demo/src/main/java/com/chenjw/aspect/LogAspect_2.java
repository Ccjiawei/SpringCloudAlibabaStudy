package com.chenjw.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 日志切面
 * 注解通知的执行顺序为：
 * @Around-@Before-（目标方法逻辑）-@Around-（@AfterReturning-@AfterThrowing）-@After-@Around
 *
 * ->@Around注解方法的前半部分业务逻辑
 * ->@Before注解方法的业务逻辑
 * ->目标方法的业务逻辑
 * ->@AfterReturning（若目标方法无异常，执行@AfterReturning注解方法的业务逻辑）
 * ->@AfterThrowing（若目标方法有异常，执行@AfterThrowing注解方法的业务逻辑）
 * ->@After（不管目标方法有无异常，都会执行@After注解方法的业务逻辑）
 * ->@Around注解方法的后半部分业务逻辑（@Around注解方法内的业务逻辑若对ProceedingJoinPoint.proceed()方法没做捕获异常处理，直接向上抛出异常，则不会执行Around注解方法的后半部分业务逻辑；若做了异常捕获处理，则会执行）。
 */
@Aspect
@Component
@Slf4j
@Order(1) //切面执行顺序
public class LogAspect_2 {

    private long startTime;
    private long endTime;

    /**
     * 切点
     */
    @Pointcut("@annotation(com.chenjw.anno.Log)")
    private void logPointCut(){}

//    @Before("logPointCut()")
    public void before(JoinPoint joinPoint){
        log.info("before2 start----------------");
    }

//    @After("logPointCut()")
    public void after(JoinPoint joinPoint){
        log.info("after2 start---------------");
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("around2 start");

        //继续执行方法
        Object result = null;
        try{
            joinPoint.proceed();
        }catch (Exception e){
            log.error("============error2 joinPoint.proceed()==========");
        }

        log.info("around2 end");
        return result;
    }

    @AfterReturning("logPointCut()")
    public void afterReturning(JoinPoint joinPoint){
        log.info("afterReturning2 start");
        log.info("afterReturning2 end");
    }

    @AfterThrowing("logPointCut()")
    public void afterThrowing(JoinPoint joinPoint){
        log.info("afterThrowing2 start");
        log.info("afterThrowing2 end");
    }

}
