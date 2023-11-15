package com.example.demo5.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CalculateService {
    private final Shape shape;
@Autowired
    public CalculateService(@Qualifier("rectangle") Shape shape) {
        this.shape = shape;
    }
    public void calculate() {
        shape.calculateArea();
    }
}
