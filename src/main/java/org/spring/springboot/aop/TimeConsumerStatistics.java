package org.spring.springboot.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class TimeConsumerStatistics {

    @Around("execution(* org.spring.springboot.service.*.*(..))")
    public Object methodTimeConsumingStatistics(ProceedingJoinPoint joinPoint) throws Throwable {
        long stime = System.currentTimeMillis();
        Object ret = joinPoint.proceed();
        long useTime = System.currentTimeMillis() - stime;
        log.info("record: {}, {}.  time used:{}", joinPoint.getTarget(), joinPoint.getSignature(), useTime);
        System.out.println("record: " + joinPoint.getTarget() + "." + joinPoint.getSignature() + " time used" + useTime);
        return ret;
    }

}
