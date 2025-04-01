package org.example;

import org.example.config.AppConfig;
import org.example.model.Order;
import org.example.service.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试类，验证Bean装配和AOP织入效果
 */
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }

        // 初始化Spring容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 获取代理后的OrderService
        OrderService orderService = context.getBean(OrderService.class);

        // 创建订单
        Order order = new Order(1, "Java编程书", 2);
        orderService.createOrder(order);

        // 查询订单
        Order result = orderService.getOrder(1);
        System.out.println("查询结果: " + result);

        context.close();
    }
}