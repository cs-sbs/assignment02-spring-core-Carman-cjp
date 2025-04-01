package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    
    @Before("execution(* org.example.service.UserService.login(..))")
    public void beforeLogin(JoinPoint joinPoint) {
        String username = (String) joinPoint.getArgs()[0];
        System.out.println("用户 " + username + " 尝试登录");
    }

    @AfterReturning(pointcut = "execution(* org.example.service.UserService.login(..))", 
                    returning = "result")
    public void afterLogin(JoinPoint joinPoint, Object result) {
        String username = (String) joinPoint.getArgs()[0];
        boolean success = (Boolean) result;
        System.out.println("用户 " + username + " 登录" + (success ? "成功" : "失败"));
    }
} 