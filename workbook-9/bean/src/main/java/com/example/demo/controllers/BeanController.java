package com.example.demo.controllers;

import com.example.demo.services.GreetingService;
import com.example.demo.services.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeanController {
    private GreetingService greetingService;
    private MessageService messageService;

    public BeanController(GreetingService greetingService, MessageService messageService) {
        this.greetingService = greetingService;
        this.messageService = messageService;
    }

    @GetMapping("/greeting")
    public String getGreeting() {
        return greetingService.getGreeting();
    }

    @GetMapping("/message")
    public String getMessage() {
        return messageService.getMessage();
    }
}
