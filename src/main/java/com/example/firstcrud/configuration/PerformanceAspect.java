package com.example.firstcrud.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@Aspect
public class PerformanceAspect {

    @Around("execution(* com.example.firstcrud.services.*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method "+pjp.getSignature().getName()+" execution time: " + elapsedTime
                +"milliseconds.");
        return obj;
    }
}
