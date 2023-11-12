package com.example.demo5.example;

import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class Rectangle implements Shape{

    @Override
    public void calculateArea() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj długość boku a: ");
        int a = scanner.nextInt();
        System.out.println("Podaj długość boku b: ");
        int b = scanner.nextInt();
        System.out.println("Powierchnia prostokąta wynosi: " + a * b);
    }
}
