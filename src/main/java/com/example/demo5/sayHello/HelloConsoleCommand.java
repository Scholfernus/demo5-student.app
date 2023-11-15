package com.example.demo5.sayHello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class HelloConsoleCommand implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.print("Hello\n");
    }
}
