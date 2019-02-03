package com.banking.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.banking.config.ApplicationContextProvider;
import com.banking.model.Greeting;
import com.banking.service.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello encountered, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        System.out.println("Test");

        Test test = ApplicationContextProvider.getApplicationContext().getBean("test", Test.class);
        test.test();

        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}