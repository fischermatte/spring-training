package org.fischermatte.training.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerInterceptor {

    @AfterReturning(pointcut = "execution(* org.fischermatte.training.spring.HelloController.getHello())")
    public void after(JoinPoint joinPoint) throws Throwable {
        System.out.println("After Returning");
    }

    @Around("execution(* org.fischermatte.training.spring.HelloController.getHello())")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Around");
        return proceedingJoinPoint.proceed();
    }

    @Around("@target(org.springframework.web.bind.annotation.RestController) && execution(* org.fischermatte.training.spring.HelloController.getHello())")
    public Object aroundWithAnnotation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Around with annotation");
        return proceedingJoinPoint.proceed();
    }

}
