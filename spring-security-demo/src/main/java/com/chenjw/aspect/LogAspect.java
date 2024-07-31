package com.chenjw.aspect;

import com.chenjw.anno.Log;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

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
@Order(2)
public class LogAspect {

    private long startTime;
    private long endTime;

    /**
     * 切点
     */
    @Pointcut("@annotation(com.chenjw.anno.Log)")
    private void logPointCut(){}

//    @Before("logPointCut()")
    public void before(JoinPoint joinPoint){
        log.info("before start----------------");
        startTime = System.currentTimeMillis();
        log.info("startTime:{}", startTime);
        log.info("before end---------------");
    }

//    @After("logPointCut()")
    public void after(JoinPoint joinPoint){
        log.info("after start---------------");
        endTime = System.currentTimeMillis();
        log.info("endTime:{}", endTime);
        log.info("costTime:{}", endTime - startTime);
        log.info("after end----------------");
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("around start");

        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        //方法名称
        String methodName = methodSignature.getName();
        Method method = methodSignature.getMethod();

        Class<?> returnType = method.getReturnType();
        //方法上的注解
        Log logAnno = method.getAnnotation(Log.class);
        String value = logAnno.value();
        startTime = System.currentTimeMillis();
        switch (value){
            case "info":
                log.info("info start log");
                log.info("method name " + methodName);
                log.info("method returnType " + returnType);
                break;
            case "debug":
                log.debug("debug start log");
                log.debug("method name " + methodName);
                log.debug("method returnType " + returnType);
                break;
            case "warn":
                log.warn("warn start log");
                log.warn("method name " + methodName);
                log.warn("method returnType " + returnType);
                break;
            case "error":
                log.error("error start log");
                log.error("method name " + methodName);
                log.error("method returnType " + returnType);
                break;
            default:
                log.info("default start log");
        }

        //继续执行方法
        Object result = null;
        try{
            joinPoint.proceed();
        }catch (Exception e){
            log.error("============error joinPoint.proceed()==========");
        }

        endTime = System.currentTimeMillis();
        switch (value){
            case "info":
                log.info("info end log");
                log.info("costTime:{}", endTime - startTime);
                break;
            case "debug":
                log.debug("debug end log");
                log.debug("costTime:{}", endTime - startTime);
                break;
            case "warn":
                log.warn("warn end log");
                log.warn("costTime:{}", endTime - startTime);
                break;
            case "error":
                log.error("error end log");
                log.error("costTime:{}", endTime - startTime);
                break;
            default:
                log.info("default end log");
        }
        log.info("around end");
        return result;
    }

    @AfterReturning("logPointCut()")
    public void afterReturning(JoinPoint joinPoint){
        log.info("afterReturning start");
        log.info("afterReturning end");
    }

    @AfterThrowing("logPointCut()")
    public void afterThrowing(JoinPoint joinPoint){
        log.info("afterThrowing start");
        log.info("afterThrowing end");
    }

}
