package org.fischermatte.training.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.fischermatte.training.spring.mvc.rest.HelloRestController;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerInterceptor {

    @Pointcut("execution(* org.fischermatte.training.spring.mvc.rest.HelloRestController.getHello(java.lang.String))")
    private void helloController(){
        // pointcut
    }

    @AfterReturning(pointcut = "helloController() && target(ctrl) && args(name)")
    public void after(JoinPoint joinPoint, HelloRestController ctrl, String name) throws Throwable {
        System.out.println("After with value: " + name);
    }

    @Before("helloController() ")
    public void before(JoinPoint joinPoint) throws Throwable {
        System.out.println("After Returning");
    }

    @Around("helloController()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Around");
        return proceedingJoinPoint.proceed();
    }

    @Around("@target(org.springframework.web.bind.annotation.RestController) && helloController()")
    public Object aroundWithAnnotation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Around with annotation");
        return proceedingJoinPoint.proceed();
    }

}
