package com.example.demo5.example;

import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebServerApplicationContext;
import org.springframework.context.ApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");
        ApplicationContext context = new AnnotationConfigReactiveWebServerApplicationContext();
        CalculateService areaService = (CalculateService) context.getBean("calculateArea");
        areaService.calculate();
    }
}
