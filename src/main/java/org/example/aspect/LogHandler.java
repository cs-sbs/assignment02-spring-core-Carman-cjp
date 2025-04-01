package org.example.aspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {
    private final Object target;

    public LogHandler(Object target) {
        this.target = target;
    }

    // 动态代理的invoke方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("[日志] 方法调用: " + method.getName());
        if (args != null) {
            for (Object arg : args) {
                System.out.println("[日志] 参数: " + arg);
            }
        }
        Object result = method.invoke(target, args);
        System.out.println("[日志] 方法返回: " + result);
        return result;
    }
} 