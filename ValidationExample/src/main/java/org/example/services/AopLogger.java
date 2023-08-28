package org.example.services;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.Date;

@Component
@Aspect
public class AopLogger {

    @Before("execution(* org.example.services..*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("Method call" + joinPoint);
    }

    @AfterReturning(value = "execution(* org.example.services..*.*(..))", returning = "result")
    public void adviceAfterReturning(JoinPoint joinPoint, Object result){
        System.out.println("Method call " + joinPoint + " result is " + result);
    }

    @AfterThrowing(value = "execution(* org.example.services..*.*(..))", throwing =  "resultThr")
    public void adviceAfterThrowing(JoinPoint joinPoint, Throwable resultThr){
        System.out.println("Method call " + joinPoint + " result is " + resultThr);
    }

    @Around(value = "execution(* org.example.services..*.*(..))")
    public Object adviceAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("(@Around) Before  method call " + joinPoint);
        Object returnValue = joinPoint.proceed();
        System.out.println("(@Around) After method call " + joinPoint);
        return returnValue;
    }

    //Самостоятельная

    @Around(value = "execution(* org.example.services..*.*(..))")
    public Object adviceAroundTransfer(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Transaction has started " + joinPoint);
        Object returnValue = null;
        try{
           returnValue  = joinPoint.proceed();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Transaction succeeded " + joinPoint);
        return returnValue;
    }
}
