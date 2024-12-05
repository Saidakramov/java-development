package com.example.demo.controllers;

import com.example.demo.Barista;
import com.example.demo.services.CoffeeShopService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeController {
    private Barista barista;
    private CoffeeShopService coffeeShopService;

    public CoffeeController(Barista barista, CoffeeShopService coffeeShopService) {
        this.barista = barista;
        this.coffeeShopService = coffeeShopService;
    }

    @GetMapping("/order/{coffeeType}")
    public String orderCoffee(@PathVariable String coffeeType) {
        return coffeeShopService.takeOrder(coffeeType) + " - " + barista.prepareCoffee() +
                " " + coffeeShopService.getRandom();
    }

    @GetMapping("/serve")
    public String serveCoffee() {
        return coffeeShopService.serveOrder();
    }
}
