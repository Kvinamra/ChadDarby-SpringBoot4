package com.vinklearns.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.vinklearns.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){}

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println("\nExecuting @Before advice for beforeAddAccountAdvice().");
    }

    @Before("forDaoPackage()")
    public void performAPIAnalytics() {
        System.out.println("Executing @Before advice for performAPIAnalytics().");
    }
}
