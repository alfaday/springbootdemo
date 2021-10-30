package com.alfaday.aop;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 通过自定义注解实现aop
 */
@Aspect
@Component
public class WebLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    //定义一个切入点
    @Pointcut("@annotation(com.alfaday.aop.LogAnnotation)")
    public void annotationPointCut(){

    }

//    @Before("annotationPointCut()")
    public void doBefore(JoinPoint joinPoint) {
        beforeAction(joinPoint);

    }

    @Around("annotationPointCut()")
    public Object surroundInform(ProceedingJoinPoint proceedingJoinPoint) {
        logger.info("环绕通知开始");
        beforeAction(proceedingJoinPoint);
        try {
            Object o =  proceedingJoinPoint.proceed();
            logger.info("环绕通知结束");
            return o;
        } catch (Throwable e) {
            logger.error("surroundInform()",e);
            return "execption!";
        }
    }

    private void beforeAction(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        LogAnnotation annotation = method.getAnnotation(LogAnnotation.class);
        // 记录请求到达时间
        //接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("URI : " + request.getRequestURI());
        logger.info("URL : " + request.getRequestURL());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info(annotation.value());
    }
}
