package com.example.demo5.example;

import java.util.Scanner;

public class Square implements Shape {

    @Override
    public void calculateArea() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj długość boku: ");
        int a = scanner.nextInt();
        System.out.println("Powierchnia kwadratu wynosi: " + a * a);
    }
}
