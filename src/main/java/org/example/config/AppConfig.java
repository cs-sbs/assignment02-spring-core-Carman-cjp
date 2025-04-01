package org.example.config;

import org.example.dao.OrderDao;
import org.example.service.OrderService;
import org.example.service.OrderServiceImpl;
import org.example.aspect.LogHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Proxy;

@Configuration
@ComponentScan("org.example")
public class AppConfig {
    // 用JDK动态代理包装OrderService
    @Bean
    public OrderService orderServiceProxy(OrderDao orderDao) {
        OrderServiceImpl impl = new OrderServiceImpl();
        impl.setOrderDao(orderDao);
        return (OrderService) Proxy.newProxyInstance(
                OrderService.class.getClassLoader(),
                new Class[]{OrderService.class},
                new LogHandler(impl)
        );
    }
} 