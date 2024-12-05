package com.example.demo.services;

import com.example.demo.CoffeeBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Scope("prototype")
public class CoffeeShopService {
    private int random = new Random().nextInt(1000);

    public int getRandom() {
        return random;
    }

    public void setRandom(int random) {
        this.random = random;
    }

    public String takeOrder(String coffeeType) {
        return "Order placed for: " + coffeeType;
    }

    public String serveOrder() {
        return "Serving coffee: " + random;
    }
}
