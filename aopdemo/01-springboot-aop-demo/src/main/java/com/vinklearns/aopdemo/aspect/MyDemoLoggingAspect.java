package com.vinklearns.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    //@Before("execution(public void add*())") // ---> call on all generic methods starting with add
    //@Before("execution(public void com.vinklearns.aopdemo.dao.AccountDAO.addAccount())") // ---> class method specific
    //@Before("execution(void add*())") // ---> call on return type
    //@Before("execution(* add*())") // ---> any return type and any methods starting with add
    //@Before("execution(* add*(com.vinklearns.aopdemo.beans.Account))") // --> matching with param
    //@Before("execution(* add*(com.vinklearns.aopdemo.beans.Account, ..))") // ---> match with any params along with Account param
    //@Before("execution(* add*(..))") // ---> for any params with matching add methods
    @Before("execution(* com.vinklearns.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\nExecuting @Before advice.");
    }
}
