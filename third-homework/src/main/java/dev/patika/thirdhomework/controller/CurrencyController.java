package dev.patika.thirdhomework.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/currency")
public class CurrencyController {

    private final static String ENDPOINT = "http://localhost:8081/currency/toTl?quantity=";
    private final static String ENDPOINT_USD = "http://localhost:8081/currency/toUSD?quantity=";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/sendQuantity")
    public String sendQuantity(@RequestParam double value){

        return restTemplate.getForEntity(ENDPOINT+value,String.class).getBody();
    }

    @GetMapping("/sendQuantityUsd")
    public String sendQuantityUsd(@RequestParam double valueUsd){
        return restTemplate.getForEntity(ENDPOINT_USD+valueUsd,String.class).getBody();
    }




}
