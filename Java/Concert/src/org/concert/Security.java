package org.concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(0)
public class Security {
    @Pointcut("execution(* org.concert.Performances.Performance.perform(..))")
    public void performance() { }

    @Around("performance()")
    public void makeSureThePerformersAreSafe(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Check if everything is OK");
        System.out.println("Escort the performer to the stage");
        joinPoint.proceed();
        System.out.println("Escort the performer to the back");
        System.out.println("Start opening the gates so the people can leave");
    }
}
