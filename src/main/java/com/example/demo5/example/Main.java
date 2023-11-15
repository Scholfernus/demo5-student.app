package com.example.demo5.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CalculateService areaService = context.getBean(CalculateService.class);
        areaService.calculate();
    }
}
