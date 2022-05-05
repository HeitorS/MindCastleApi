package br.com.engdb.agv.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.engdb.agv.model.Cliente;

@RestController
public class ClienteController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @RequestMapping("/greeting")
    public Cliente greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Cliente(counter.incrementAndGet(), String.format(template, name));
    }
    
}
