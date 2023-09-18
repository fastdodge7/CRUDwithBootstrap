package com.example.myPage.CRUDwithBootstrap.Aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimerAop {
    @Around("execution(* com.example.myPage.CRUDwithBootstrap.Controller.MemberController.*(..))")
    public Object printExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();
        try{
            Object ret = joinPoint.proceed();
            return ret;
        }finally{
            long endTime = System.currentTimeMillis();
            System.out.println(joinPoint.toString() + " execution Time : " + (endTime - startTime) / 1000 + " second.");
        }
    }
}
