package com.example.demo5.sayHello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Order(1)
@Component
public class PrintConsoleArgumentsCommand implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("Console properties are {}", Arrays.asList(args));
    }
}
