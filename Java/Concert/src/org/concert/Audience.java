package org.concert;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class Audience {
    @Pointcut("execution(* org.concert.Performances.Performance.perform(..))")
    public void performance() {

    }

    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("SilencingCellPhones");
    }

    @Before("performance()")
    public void takeSeat() {
        System.out.println("Taking Seats");
    }

    @AfterReturning("performance()")
    public void applause() {
        System.out.println("CLAP, CLAP, CLAP");
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Demanding Refund!!!");
    }

}
