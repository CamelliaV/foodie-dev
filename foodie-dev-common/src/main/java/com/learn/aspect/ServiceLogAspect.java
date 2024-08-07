package com.learn.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Log4j2
public class ServiceLogAspect {

    private static final long ERROR_SPAN = 3000L;
    private static final long WARN_SPAN = 2000L;

    @Around("execution(* com.learn.service.impl..*.*(..))")
    public Object recordTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("====== Execution on {}.{} ======",
                joinPoint
                        .getTarget()
                        .getClass(),
                joinPoint
                        .getSignature()
                        .getName());

        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();
        long take = end - start;
        if (take > ERROR_SPAN) {
            log.error("====== Execution off; taking: {} ms ======", take);
        } else if (take > WARN_SPAN) {
            log.warn("====== Execution off; taking: {} ms ======", take);
        } else {
            log.info("====== Execution off; taking: {} ms ======", take);
        }

        return result;
    }
}
