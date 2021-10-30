package com.alfaday.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;


/**
 * 通过包名实现aop，暂时不启用
 */
@Aspect
@Component
public class TimeAspect {
    private static final Logger LOG = LoggerFactory.getLogger(TimeAspect.class);

//    @Around("execution(* com.alfaday.controller.*.*(..))")
//    public Object handleControllerMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        LOG.info("切片开始。。。");
//        long startTime = System.currentTimeMillis();
//
//        // 获取请求入参
//        Object[] args = proceedingJoinPoint.getArgs();
//        Arrays.stream(args).forEach(arg -> LOG.info("arg is {}", arg));
//
//        // 获取响应
//        Object response = proceedingJoinPoint.proceed();
//        long endTime = System.currentTimeMillis();
//        LOG.info("请求:{}, 耗时{}ms", proceedingJoinPoint.getSignature(), (endTime - startTime));
//        LOG.info("切片结束。。。");
//        return null;
//    }
}