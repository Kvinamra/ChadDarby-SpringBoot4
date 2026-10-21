package com.vinklearns.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Before("execution(public void add*())")
    public void beforeAddAccountAdvice() {
        System.out.println(getClass() + " : BEFORE ADVICE CALLED.");
    }
}
